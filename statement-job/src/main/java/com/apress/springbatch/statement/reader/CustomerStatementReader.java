package com.apress.springbatch.statement.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.apress.springbatch.statement.domain.Customer;

public class CustomerStatementReader implements ItemReader<Customer> {

    private Customer curItem = null;

    private ItemReader<Customer> delegate;

    public Customer read() throws Exception, UnexpectedInputException,
            ParseException {
        int count = 0;
        do {
            ++count;
            Customer customer = curItem;
            curItem = (Customer) delegate.read();

            if ((customer != null && curItem == null) || customer != null
                    && (customer.getId() != (curItem.getId()))) {
                return customer;
            }

            if (customer != null) {
                merge(customer);
            }
        } while (curItem != null);

        return null;
    }

    private void merge(Customer customer) {
        curItem.getAccount().getTransactions()
                .add(customer.getAccount().getTransactions().get(0));
    }

    public void setDelegate(ItemReader<Customer> delegate) {
        this.delegate = delegate;
    }

    public void update(ExecutionContext arg0) throws ItemStreamException {
//        delegate.update(arg0);
    }
}
