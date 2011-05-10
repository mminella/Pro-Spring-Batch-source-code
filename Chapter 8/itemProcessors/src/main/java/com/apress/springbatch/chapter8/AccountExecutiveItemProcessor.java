package com.apress.springbatch.chapter8;

import org.springframework.batch.item.ItemProcessor;

public class AccountExecutiveItemProcessor implements ItemProcessor<Customer, Customer> {

    private AccountExecutiveDao accountExecutiveDao;
    
    public Customer process(Customer customer) {
        customer.setAccountExecutive(accountExecutiveDao.getAccountExecutiveByCustomer(customer));
        
        return customer;
    }

    public void setAccountExecutiveDao(AccountExecutiveDao accountExecutiveDao) {
        this.accountExecutiveDao = accountExecutiveDao;
    }
    
}
