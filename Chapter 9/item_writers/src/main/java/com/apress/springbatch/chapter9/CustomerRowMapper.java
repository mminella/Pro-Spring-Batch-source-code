package com.apress.springbatch.chapter9;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
        Customer customer = new Customer();
        
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setEmail(rs.getString("email"));
        customer.setFirstName(rs.getString("firstName"));
        customer.setId(rs.getLong("id"));
        customer.setLastName(rs.getString("lastName"));
        customer.setMiddleInitial(rs.getString("middleInitial"));
        customer.setState(rs.getString("state"));
        customer.setZip(rs.getString("zip"));
        
        return customer;
    }

}
