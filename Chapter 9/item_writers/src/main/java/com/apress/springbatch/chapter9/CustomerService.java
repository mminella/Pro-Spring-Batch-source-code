package com.apress.springbatch.chapter9;

public interface CustomerService {
    void logCustomer(Customer cust);
    void logAddress(String address, String city, String state, String zip);
}
