package com.apress.springbatch.statement.dao;

import com.apress.springbatch.statement.domain.Transaction;

public interface TransactionDao {
    void saveTransaction(Transaction transaction);
}
