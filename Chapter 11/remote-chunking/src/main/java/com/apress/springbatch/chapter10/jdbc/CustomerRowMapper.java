package com.apress.springbatch.chapter10.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.chapter10.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
        Customer cust = new Customer();
        
        cust.setAddress(rs.getString("address"));
        cust.setCity(rs.getString("city"));
        cust.setFirstName(rs.getString("firstName"));
        cust.setId(rs.getLong("id"));
        cust.setLastName(rs.getString("lastName"));
        cust.setState(rs.getString("state"));
        cust.setZip(rs.getString("zip"));
        
        return cust;
    }

}
