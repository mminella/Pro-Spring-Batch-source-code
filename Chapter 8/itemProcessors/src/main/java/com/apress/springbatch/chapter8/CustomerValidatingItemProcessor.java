package com.apress.springbatch.chapter8;

import org.springframework.batch.item.validator.ValidatingItemProcessor;

public class CustomerValidatingItemProcessor extends ValidatingItemProcessor<Customer> {

    private int recordCount = 0;
    
    @Override
    public Customer process(Customer customer) {
        recordCount++;
        
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " was record number " + recordCount + " in our file.");
        
        return customer;
    }
}
