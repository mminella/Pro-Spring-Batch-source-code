package com.apress.springbatch.chapter7;

import org.springframework.batch.item.file.transform.LineAggregator;

public class CustomerLineAggregator implements LineAggregator<Object> {

    private LineAggregator<Customer> customerLineAggregator;
    private LineAggregator<Transaction> transactionLineAggregator;
    
    public String aggregate(Object record) {
        if(record instanceof Customer) {
            return customerLineAggregator.aggregate((Customer) record);
        } else {
            return transactionLineAggregator.aggregate((Transaction) record);
        }
    }

    public void setCustomerLineAggregator(
            LineAggregator<Customer> customerLineAggregator) {
        this.customerLineAggregator = customerLineAggregator;
    }

    public void setTransactionLineAggregator(
            LineAggregator<Transaction> transactionLineAggregator) {
        this.transactionLineAggregator = transactionLineAggregator;
    }

}
