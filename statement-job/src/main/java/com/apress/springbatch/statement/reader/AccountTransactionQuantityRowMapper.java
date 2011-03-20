package com.apress.springbatch.statement.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.domain.AccountTransactionQuantity;

public class AccountTransactionQuantityRowMapper implements RowMapper {

    public AccountTransactionQuantity mapRow(ResultSet resultSet, int arg1) throws SQLException {
        AccountTransactionQuantity qty = new AccountTransactionQuantity();
        
        qty.setAccountNumber(resultSet.getString("accountNumber"));
        qty.setTransactionCount(resultSet.getLong("qty"));
        
        return qty;
    }

}
