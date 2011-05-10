package com.apress.springbatch.chapter10.processor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.batch.item.ItemReader;

import com.apress.springbatch.chapter10.domain.Customer;
import com.apress.springbatch.chapter10.domain.Order;
import com.apress.springbatch.chapter10.domain.OrderItem;

public class OrderGenerator implements ItemReader<Order> {
    
    private static final String [] STREETS = {"Second", "Third", "Fourth", "Park", "Fifth", "Main", "Sixth", "Oak", "Seventh", "Pine", "Maple"};
    private static final String[] CITIES = {"Franklin", "Clinton", "Springfield", "Greenville", "Salen", "Fairview", "Madison"};
    private static final String[] FIRST_NAME = {"Jacob", "Ethan", "Michael", "Alexander", "William", "Joshua", "Daniel", "Jayden", "Noah", "Anthony", "Isabella", "Emma", "Olivia", "Sophia", "Ava", "Emily", "Madison", "Abigail", "Chloe", "Mia"};
    private static final String[] LAST_NAME = {"Smith", "Jones", "Thompson", "Williams", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris"};
    private static final String[] STATES = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    
    private Random generator = new Random();
    private DateFormat formatter = new SimpleDateFormat("MM/yy");
    private int counter = 0;

    public Order read() throws Exception {
        if(counter < 20000) {
            Order curOrder = new Order();
            
            curOrder.setCreditCardNumber(String.valueOf(generator.nextLong()));
            curOrder.setCustomer(buildCustomer());
            curOrder.setExpirationDate(formatter.format(new Date()));
            curOrder.setPlacedOn(new Date());
            curOrder.setItems(buildItems(curOrder));

            counter ++;
            
            return curOrder;
        } else {
            return null;
        }
    }

    private List<OrderItem> buildItems(Order order) {
        List<OrderItem> items = new ArrayList<OrderItem>();
        int total = 0;
        
        while(total <= 0) {
            total = generator.nextInt(10);
        }
        
        for(int i = 0; i < total; i++) {
            OrderItem item = new OrderItem();
            
            item.setItemNumber(String.format("%09d", generator.nextLong()));
            item.setPrice(BigDecimal.valueOf(generator.nextDouble()));
            item.setQty(generator.nextInt(5));
            item.setOrder(order);
            
            items.add(item);
        }
        
        return items;
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        
        customer.setAddress(generator.nextInt(999) + " " + STREETS[counter % STREETS.length]);
        customer.setCity(CITIES[counter % CITIES.length]);
        customer.setCustomerName(FIRST_NAME[counter % FIRST_NAME.length] + " " + LAST_NAME[counter % LAST_NAME.length]);
        customer.setState(STATES[counter % STATES.length]);
        customer.setZip(String.format("%05d", generator.nextInt(99999)));
        
        return customer;
    }

}
