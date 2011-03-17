package com.apress.springbatch.chapter9;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class CustomerItemPreparedStatementSetter implements
        ItemPreparedStatementSetter<Customer> {

    public void setValues(Customer customer, PreparedStatement ps)
            throws SQLException {

        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getMiddleInitial());
        ps.setString(3, customer.getLastName());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getCity());
        ps.setString(6, customer.getState());
        ps.setString(7, customer.getZip());
        ps.setString(8, customer.getEmail());

    }
}
