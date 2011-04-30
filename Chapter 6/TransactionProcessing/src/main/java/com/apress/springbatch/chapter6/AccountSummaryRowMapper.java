package com.apress.springbatch.chapter6;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountSummaryRowMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        AccountSummary summary = new AccountSummary();
        
        summary.setAccountNumber(resultSet.getString("account_number"));
        summary.setCurrentBalance(resultSet.getDouble("current_balance"));
        
        return summary;
    }

}
