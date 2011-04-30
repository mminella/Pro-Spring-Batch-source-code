package com.apress.springbatch.chapter6;

import java.util.List;

public interface TransactionDao {
    
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);

}
