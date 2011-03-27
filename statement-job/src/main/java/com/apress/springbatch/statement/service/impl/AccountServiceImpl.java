package com.apress.springbatch.statement.service.impl;

import java.util.List;

import com.apress.springbatch.statement.dao.AccountDao;
import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public List<Account> getAccounts() {
        return accountDao.loadAccounts();
    }
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
