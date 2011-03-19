package com.apress.springbatch.statement.dao;

import com.apress.springbatch.statement.domain.Customer;

public interface CustomerDao {

    Customer findCustomerByTaxId(String taxId);
    void saveCustomer(Customer customer);
}
