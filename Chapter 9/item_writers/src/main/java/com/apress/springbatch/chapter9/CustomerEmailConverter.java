package com.apress.springbatch.chapter9;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

public class CustomerEmailConverter implements ItemProcessor<Customer, SimpleMailMessage> {

    @Override
    public SimpleMailMessage process(Customer customer) throws Exception {
        SimpleMailMessage mail = new SimpleMailMessage();
        
        mail.setFrom("prospringbatch@michaelminella.com");
        mail.setTo("michael@michaelminella.com");
        mail.setSubject("The customer email");
        mail.setText(customer.toString());
        
        return mail;
    }
}
