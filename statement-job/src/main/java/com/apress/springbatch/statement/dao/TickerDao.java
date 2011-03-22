package com.apress.springbatch.statement.dao;

import java.math.BigDecimal;
import java.util.List;

import com.apress.springbatch.statement.domain.Ticker;
import com.apress.springbatch.statement.domain.Transaction;

public interface TickerDao {

    Ticker findTickerBySymbol(String symbol);
    void saveTicker(Ticker ticker);
    List<String> getTickersPaged(int page, int pageSize);
    BigDecimal getTotalValueForCustomer(long id);
    List<Transaction> getStocksForCustomer(long id);
}