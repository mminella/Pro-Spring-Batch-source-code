package com.apress.springbatch.statement.processor;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.statement.dao.AccountDao;
import com.apress.springbatch.statement.dao.CustomerDao;
import com.apress.springbatch.statement.dao.TickerDao;
import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.Ticker;
import com.apress.springbatch.statement.domain.Transaction;
import com.apress.springbatch.statement.domain.TransactionType;
import com.apress.springbatch.statement.exception.InvalidItemException;

public class CustomerLookupItemProcessor implements ItemProcessor<Object, Object> {
    
    private CustomerDao customerDao;
    private TickerDao tickerDao;
    private AccountDao accountDao;

    public Object process(Object curItem) throws Exception {
        if(curItem instanceof Customer) {
            return doCustomerUpdate((Customer) curItem);
        } else if(curItem instanceof Transaction){
            return doTransactionupdate((Transaction) curItem);
        } else {
            throw new InvalidItemException("An invalid item was received: " + curItem);
        }
    }

    private Transaction doTransactionupdate(Transaction curItem) {
        updateTicker(curItem);
        updateAccount(curItem);
        
        curItem.setType(TransactionType.STOCK);
        
        return curItem;
    }

    private void updateAccount(Transaction curItem) {
        Account account = accountDao.findAccountByNumber(curItem.getAccountNumber());
        
        if(account == null) {
            account = new Account();
            account.setAccountNumber(curItem.getAccountNumber());
            account.setCashBalance(new BigDecimal(0));
            
            //TODO set customer on account before saving
        }
        
        curItem.setAccountId(account.getId());
    }

    private void updateTicker(Transaction curItem) {
        Ticker ticker = tickerDao.findTickerBySymbol(curItem.getTicker());
        
        if(ticker == null) {
            Ticker newTicker = new Ticker();
            newTicker.setTicker(curItem.getTicker());
            
            tickerDao.saveTicker(newTicker);
            ticker = tickerDao.findTickerBySymbol(curItem.getTicker());
        }
        
        curItem.setTickerId(ticker.getId());
    }

    private Customer doCustomerUpdate(Customer curCustomer) {
        Customer storedCustomer = customerDao.findCustomerByTaxId(curCustomer.getTaxId());
        
        if(storedCustomer != null) {
            curCustomer.setId(storedCustomer.getId());
        }
        
        return curCustomer;
    }
    
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setTickerDao(TickerDao tickerDao) {
        this.tickerDao = tickerDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
