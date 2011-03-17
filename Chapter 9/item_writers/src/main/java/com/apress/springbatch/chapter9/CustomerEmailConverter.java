package com.apress.springbatch.chapter9;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

public class CustomerEmailConverter implements ItemProcessor<Customer, SimpleMailMessage> {

    private static final String EMAIL_TEMPLATE = "Welcome %s,\nYou were imported into our system using Spring Batch!";

    @Override
    public SimpleMailMessage process(Customer customer) throws Exception {
        SimpleMailMessage mail = new SimpleMailMessage();
        
        mail.setFrom("prospringbatch@apress.com");
        mail.setTo(customer.getEmail());
        mail.setSubject("Welcome!");
        mail.setText(String.format(EMAIL_TEMPLATE, new Object[] {customer.getFirstName(), customer.getLastName()}));
        
        return mail;
    }
}
