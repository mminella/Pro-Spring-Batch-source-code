package com.apress.springbatch.chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class CustomerItemReader implements ItemStreamReader<Customer> {
    
    private List<Customer> customers;
    private int curIndex;
    private String INDEX_KEY = "current.index.customers";
    
    private String [] firstNames = {"Michael", "Warren", "Ann", "Terrence", "Erica", "Laura", "Warren", "Steve", "Larry", "Barack"};
    private String middleInitial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String [] lastNames = {"Minella", "Gates", "Darrow", "Donnelly", "Benes", "Jobs", "Buffett", "Ellison", "Obama"};
    private String [] streets = {"4th Street", "Wall Street", "Fifth Avenue", "Mt. Lee Drive", "Jeopardy Lane", "Infinite Loop Drive", "Farnam Street", "Isabella Ave", "S. Greenwood Ave"};
    private String [] cities = {"Chicago", "New York", "Hollywood", "Aurora", "Omaha", "Atherton"};
    private String [] states = {"IL", "NY", "CA", "NE"};
    
    private Random generator = new Random();

    public CustomerItemReader() {
        customers = new ArrayList<Customer>();
        
        for(int i = 0; i < 100; i++) {
            customers.add(buildCustomer());
        }
    }
    
    private Customer buildCustomer() {
        Customer customer = new Customer();
        
        customer.setFirstName(firstNames[generator.nextInt(firstNames.length - 1)]);
        customer.setMiddleInitial(String.valueOf(middleInitial.charAt(generator.nextInt(middleInitial.length() - 1))));
        customer.setLastName(lastNames[generator.nextInt(lastNames.length - 1)]);
        customer.setAddress(generator.nextInt(9999) + " " + streets[generator.nextInt(streets.length - 1)]);
        customer.setCity(cities[generator.nextInt(cities.length - 1)]);
        customer.setState(states[generator.nextInt(states.length - 1)]);
        customer.setZip(String.valueOf(generator.nextInt(99999)));
        
        return customer;
    }

    public Customer read() {
        Customer cust = null;
        
        if(curIndex == 50) {
            throw new RuntimeException("This will end our execution");
        }
        
        if(curIndex < customers.size()) {
            cust = customers.get(curIndex);
            curIndex++;
        }
        
        return cust;
    }

    public void close() throws ItemStreamException {
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {
        if(executionContext.containsKey(INDEX_KEY)) {
            int index = executionContext.getInt(INDEX_KEY);
            
            if(index == 50) {
                curIndex = 51;
            } else {
                curIndex = index;
            }
        } else {
            curIndex = 0;
        }
    }

    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.putInt(INDEX_KEY, curIndex);
    }

}
