package com.apress.springbatch.statement.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.apress.springbatch.statement.dao.TransactionDao;
import com.apress.springbatch.statement.domain.Transaction;

public class TransactionDaoJdbc extends JdbcTemplate implements TransactionDao {

    private static final String INSERT_TRANSACTION = "insert into transaction (transactionType, executedTime, dollarAmount, qty, tickerId, account_id) values (?, ?, ?, ?, ?, ?)";

    public void saveTransaction(Transaction transaction) {
        update(INSERT_TRANSACTION, new Object[] { transaction.getType().getIntValue(),
                transaction.getTradeTimestamp(), transaction.getDollarAmount(),
                transaction.getQuantity(),
                transaction.getTickerId(),
                transaction.getAccountId()});
    }
}
