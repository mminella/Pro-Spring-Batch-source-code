package com.apress.springbatch.statement.dao;

import com.apress.springbatch.statement.domain.Account;

public interface AccountDao {
    Account findAccountByNumber(String accountNumber);
}
