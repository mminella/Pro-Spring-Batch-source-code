package com.apress.springbatch.statement.service.impl;

import com.apress.springbatch.statement.dao.AccountDao;
import com.apress.springbatch.statement.dao.CustomerDao;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    
    private CustomerDao customerDao;
    private AccountDao accountDao;

    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " was saved!!!!");
        Customer newCust = customerDao.findCustomerByTaxId(customer.getTaxId());
        customer.getAccount().setCust(newCust);
        
        if(customer.getAccount() != null && customer.getAccount().getId() < 0) {
            System.out.println("the account is going to be saved with number " + customer.getAccount().getAccountNumber());
            accountDao.saveAccount(customer.getAccount());
        }
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
