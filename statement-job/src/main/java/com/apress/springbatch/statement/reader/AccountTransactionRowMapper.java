package com.apress.springbatch.statement.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.domain.AccountTransaction;
import com.apress.springbatch.statement.domain.PricingTier;

public class AccountTransactionRowMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
        AccountTransaction accountTransaction = new AccountTransaction();
        
        accountTransaction.setAccountId(resultSet.getLong("accountId"));
        accountTransaction.setAccountNumber(resultSet.getString("accountNumber"));
        accountTransaction.setId(resultSet.getLong("transactionId"));
        accountTransaction.setQuantity(resultSet.getLong("qty"));
        accountTransaction.setTicker(resultSet.getString("ticker"));
        accountTransaction.setTier(PricingTier.convert(resultSet.getInt("tier")));
        accountTransaction.setTradeTimestamp(resultSet.getDate("executedTime"));
        accountTransaction.setPrice(resultSet.getBigDecimal("dollarAmount"));
        
        return accountTransaction;
    }

}
