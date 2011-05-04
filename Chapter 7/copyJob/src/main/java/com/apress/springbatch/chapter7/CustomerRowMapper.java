package com.apress.springbatch.chapter7;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper {

    public Customer mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Customer customer = new Customer();
        
        customer.setId(resultSet.getLong("id"));
        customer.setAddress(resultSet.getString("address"));
        customer.setCity(resultSet.getString("city"));
        customer.setFirstName(resultSet.getString("firstName"));
        customer.setLastName(resultSet.getString("lastName"));
        customer.setMiddleInitial(resultSet.getString("middleInitial"));
        customer.setState(resultSet.getString("state"));
        customer.setZip(resultSet.getString("zip"));
        
        return customer;
    }

}
