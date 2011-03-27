package com.apress.springbatch.statement.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;

import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.service.AccountService;

public class AccountReader implements ItemStreamReader<Account> {
    
    private ListItemReader<Account> accountReader;
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account read() throws Exception, UnexpectedInputException,
            ParseException {
        return accountReader.read();
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {
        accountReader = new ListItemReader<Account>(accountService.getAccounts());
    }

    public void close() throws ItemStreamException {
    }

    public void update(ExecutionContext arg0) throws ItemStreamException {
    }
}
