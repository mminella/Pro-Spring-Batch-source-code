package com.apress.springbatch.chapter8;

public interface CustomerDao {
    public Customer getCustomerByNameAndZip(String firstName, String lastName, String zip);
}
