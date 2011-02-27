package com.apress.springbatch.chapter9;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void saveCustomer(Customer cust) {
        System.out.println("I just saved " + cust);
    }

    @Override
    public void saveAddress(String address, String city, String state,
            String zip) {
        System.out.println("I just saved the address:\n" + address + "\n" + city + ", " + state + "\n" + zip);
    }

}
