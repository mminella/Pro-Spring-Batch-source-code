package com.apress.springbatch.statement.service.impl;

import com.apress.springbatch.statement.dao.TransactionDao;
import com.apress.springbatch.statement.domain.Transaction;
import com.apress.springbatch.statement.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;
    
    public void saveTransaction(Transaction transaction) {
        transactionDao.saveTransaction(transaction);
    }

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
}
