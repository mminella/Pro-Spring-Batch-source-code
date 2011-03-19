package com.apress.springbatch.statement.reader;

import java.util.ArrayList;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.Transaction;

public class CustomerFileReader implements
        ResourceAwareItemReaderItemStream<Object> {

    private Object curItem = null;

    private ResourceAwareItemReaderItemStream<Object> delegate;

    public Object read() throws Exception {
        if (curItem == null) {
            curItem = (Customer) delegate.read();
        }

        Customer customer = (Customer) curItem;
        curItem = null;

        if (customer != null) {
            customer.getAccount().setTransactions(new ArrayList<Transaction>());

            while (peek() instanceof Transaction) {
                Transaction trans = (Transaction) curItem;
                
                trans.setAccountId(customer.getAccount().getId());
                customer.getAccount().getTransactions().add(trans);
                curItem = null;
            }
        }

        return customer;
    }

    public Object peek() throws Exception, UnexpectedInputException,
            ParseException {
        if (curItem == null) {
            Object object = delegate.read();
            
            curItem = object;
        }
        
        return curItem;
    }

    public void setDelegate(ResourceAwareItemReaderItemStream<Object> delegate) {
        this.delegate = delegate;
    }

    public void close() throws ItemStreamException {
        delegate.close();
    }

    public void open(ExecutionContext arg0) throws ItemStreamException {
        delegate.open(arg0);
    }

    public void update(ExecutionContext arg0) throws ItemStreamException {
        delegate.update(arg0);
    }

    public void setResource(Resource arg0) {
        delegate.setResource(arg0);
    }
}
