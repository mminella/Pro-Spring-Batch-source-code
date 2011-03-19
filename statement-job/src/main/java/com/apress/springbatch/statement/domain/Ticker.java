package com.apress.springbatch.statement.domain;

import java.math.BigDecimal;

public class Ticker {

    private long id;
    private String ticker;
    private BigDecimal price;
    
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return ticker + " closed at " + price;
    }
}
