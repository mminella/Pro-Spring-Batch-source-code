package com.apress.springbatch.statement.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private long id;
    private long accountId;
    private String accountNumber;
    private String ticker;
    private long tickerId;
    private long quantity;
    private Date tradeTimestamp;
    private BigDecimal dollarAmount;
    private TransactionType type;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public Date getTradeTimestamp() {
        return tradeTimestamp;
    }
    public void setTradeTimestamp(Date tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }
    public BigDecimal getDollarAmount() {
        return dollarAmount;
    }
    public void setDollarAmount(BigDecimal fee) {
        this.dollarAmount = fee;
    }
    public long getTickerId() {
        return tickerId;
    }
    public void setTickerId(long tickerId) {
        this.tickerId = tickerId;
    }
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Override
    public String toString() {
        return "Sold " + quantity + " of " + ticker;
    }
}
