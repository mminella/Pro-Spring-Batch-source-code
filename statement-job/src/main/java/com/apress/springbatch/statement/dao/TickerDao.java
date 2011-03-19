package com.apress.springbatch.statement.dao;

import com.apress.springbatch.statement.domain.Ticker;

public interface TickerDao {

    Ticker findTickerBySymbol(String symbol);
    void saveTicker(Ticker ticker);
}