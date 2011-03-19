package com.apress.springbatch.statement.service;

import com.apress.springbatch.statement.domain.Transaction;

public interface TransactionService {
    void saveTransaction(Transaction transaction);
}
