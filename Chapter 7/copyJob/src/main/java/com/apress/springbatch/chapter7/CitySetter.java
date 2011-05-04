package com.apress.springbatch.chapter7;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class CitySetter implements PreparedStatementSetter {

    private String city;

    public void setValues(PreparedStatement ps) throws SQLException {
        System.out.println("*********** " + city);
        ps.setString(1, city);
    }

    public void setCity(String city) {
        this.city = city;
    }
}
