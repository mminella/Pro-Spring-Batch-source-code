package com.apress.springbatch.chapter9;

import org.springframework.batch.item.mail.MailErrorHandler;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;

public class CustomerMailErrorHandler implements MailErrorHandler {

    @Override
    public void handle(MailMessage message, Exception exception) throws MailException {
        System.out.println("The sending of our email failed:" + exception.getMessage());
    }
}
