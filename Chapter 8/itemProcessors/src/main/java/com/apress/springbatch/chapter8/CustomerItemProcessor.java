package com.apress.springbatch.chapter8;

import org.springframework.batch.item.ItemProcessor;

public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {

    private CustomerDao customerDao;
    
    public Customer process(Customer customer) {
        Customer currentCustomer = customerDao.getCustomerByNameAndZip(customer.getFirstName(), customer.getLastName(), customer.getZip());
        
        if(currentCustomer != null) {
            customer.setId(currentCustomer.getId());
            return customer;
        } else {
            return null;
        }
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
