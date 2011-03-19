package com.apress.springbatch.statement.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.domain.AccountTransaction;
import com.apress.springbatch.statement.domain.PricingTier;

public class AccountTransactionRowMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
        AccountTransaction accountTransaction = new AccountTransaction();
        
        accountTransaction.setAccountId(resultSet.getLong("account_id"));
        accountTransaction.setAccountNumber(resultSet.getString("account_number"));
        accountTransaction.setId(resultSet.getLong("transaction_id"));
        accountTransaction.setQuantity(resultSet.getLong("quantity"));
        accountTransaction.setTicker(resultSet.getString("ticker"));
        accountTransaction.setTier(PricingTier.convert(resultSet.getInt("pricing_tier")));
        accountTransaction.setTradeTimestamp(resultSet.getDate("trade_timestamp"));
        
        return accountTransaction;
    }

}
