package com.apress.springbatch.chapter8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDaoImpl extends JdbcTemplate implements CustomerDao {

    private static final String BY_ATTRIBUTES = "select * from customer where firstName = ? and lastName = ? and zip = ?";

    @SuppressWarnings("unchecked")
    public Customer getCustomerByNameAndZip(String firstName, String lastName,
            String zip) {
        List<Customer> customers = query(BY_ATTRIBUTES, new Object [] {firstName, lastName, zip}, new RowMapper() {

            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Customer result = new Customer();
                
                result.setFirstName(rs.getString("firstName"));
                result.setLastName(rs.getString("lastName"));
                result.setAddress(rs.getString("address"));
                result.setCity(rs.getString("city"));
                result.setState(rs.getString("state"));
                result.setZip(rs.getString("zip"));
                result.setId(rs.getLong("id"));
                
                return result;
            }
        });
        
        if(customers != null && customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }
    
}
