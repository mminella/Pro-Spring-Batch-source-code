package com.apress.springbatch.statement.dao;

import java.util.List;

import com.apress.springbatch.statement.domain.Account;

public interface AccountDao {
    Account findAccountByNumber(String accountNumber);
    void saveAccount(Account account);
    List<Account> loadAccounts();
}
