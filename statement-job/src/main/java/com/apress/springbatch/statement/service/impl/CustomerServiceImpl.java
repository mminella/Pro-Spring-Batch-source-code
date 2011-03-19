package com.apress.springbatch.statement.service.impl;

import com.apress.springbatch.statement.dao.CustomerDao;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    
    private CustomerDao customerDao;

    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
