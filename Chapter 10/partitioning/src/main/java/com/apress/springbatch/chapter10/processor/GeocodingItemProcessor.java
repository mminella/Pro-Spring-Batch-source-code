package com.apress.springbatch.chapter10.processor;

import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.chapter10.domain.Customer;

public class GeocodingItemProcessor implements ItemProcessor<Customer, Customer> {
    
    private static final String COMMA = ",";
    private static final String UTF_8 = "UTF-8";
    private String url;

    public Customer process(Customer customer) throws Exception {
        System.out.println("****************** I'm going to process " + customer);
        HttpClient client = new DefaultHttpClient();

        String address = buildAddress(customer);
        
        if(address == null) {
            return null;
        }

        HttpGet get = new HttpGet(url + "?q=" + address);
        
        HttpResponse response = client.execute(get);

        HttpEntity entity = response.getEntity();
        
        String coordinantes = IOUtils.toString(entity.getContent());
        coordinantes = StringUtils.strip(coordinantes);
        
        if(coordinantes.length() > 0) {
            String [] values = coordinantes.split(COMMA);
            customer.setLongitude(Double.valueOf(values[0]));
            customer.setLatitude(Double.valueOf(values[1]));
        }
        
        return customer;
    }

    private String buildAddress(Customer customer) throws Exception {
        if(customer.getCity() == null && customer.getZip() == null) {
            return null;
        } else {
            StringBuilder address = new StringBuilder();
            
            address.append(StringUtils.defaultIfEmpty(URLEncoder.encode(customer.getCity(), UTF_8) + COMMA, ""));
            address.append(StringUtils.defaultIfEmpty(URLEncoder.encode(customer.getState(), UTF_8) + COMMA, ""));
            address.append(StringUtils.defaultIfEmpty(URLEncoder.encode(customer.getZip(), UTF_8) + COMMA, ""));
            
            return address.substring(0, address.length() - 1);
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
