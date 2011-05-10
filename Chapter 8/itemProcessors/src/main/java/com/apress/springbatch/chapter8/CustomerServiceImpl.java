package com.apress.springbatch.chapter8;

public class CustomerServiceImpl {
    
    private AccountExecutiveDao acctExecDao;
    
    public AccountExecutive getAccountExecutiveForCustomer(Customer customer) {
        return acctExecDao.getAccountExecutiveByCustomer(customer);
    }
}
