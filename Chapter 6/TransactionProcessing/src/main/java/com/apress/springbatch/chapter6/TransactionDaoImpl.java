package com.apress.springbatch.chapter6;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TransactionDaoImpl extends JdbcTemplate implements TransactionDao {

    @SuppressWarnings("unchecked")
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return query(
                "select t.id, t.timestamp, t.amount from transaction t inner join " +
                "account_summary a on a.id = t.account_summary_id where a.account_number = ?",
                new Object[] { accountNumber },
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
                        Transaction trans = new Transaction();
                        trans.setAmount(rs.getDouble("amount"));
                        trans.setTimestamp(rs.getDate("timestamp"));
                        return trans;
                    }
                }
        );
    }

}
