package com.apress.springbatch.statement.dao;

import java.util.List;

import com.apress.springbatch.statement.domain.Ticker;

public interface TickerDao {

    Ticker findTickerBySymbol(String symbol);
    void saveTicker(Ticker ticker);
    List<String> getTickersPaged(int page, int pageSize);
}