package com.apress.springbatch.chapter9;

public interface CustomerService {
    void saveCustomer(Customer cust);
    void saveAddress(String address, String city, String state, String zip);
}
