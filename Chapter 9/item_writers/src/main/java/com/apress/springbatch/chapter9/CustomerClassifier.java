package com.apress.springbatch.chapter9;

import org.springframework.batch.classify.Classifier;
import org.springframework.batch.item.ItemWriter;

public class CustomerClassifier implements Classifier<Customer, ItemWriter<Customer>> {

    private ItemWriter<Customer> fileItemWriter;
    private ItemWriter<Customer> jdbcItemWriter;

    @Override
    public ItemWriter<Customer> classify(Customer customer) {
        if(customer.getState().matches("^[A-M].*")) {
            return fileItemWriter;
        } else {
            return jdbcItemWriter;
        }
    }

    public void setFileItemWriter(ItemWriter<Customer> fileItemWriter) {
        this.fileItemWriter = fileItemWriter;
    }

    public void setJdbcItemWriter(ItemWriter<Customer> jdbcItemWriter) {
        this.jdbcItemWriter = jdbcItemWriter;
    }
}
