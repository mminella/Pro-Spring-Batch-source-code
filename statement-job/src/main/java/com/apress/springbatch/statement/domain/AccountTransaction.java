package com.apress.springbatch.statement.domain;

import java.math.BigDecimal;

public class AccountTransaction extends Transaction {

    private String accountNumber;
    private PricingTier tier;
    private BigDecimal fee;
    private long quantity;
    private BigDecimal price;
    
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getFee() {
        return fee;
    }
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public PricingTier getTier() {
        return tier;
    }
    public void setTier(PricingTier tier) {
        this.tier = tier;
    }
    @Override
    public String toString() {
        return getId() + ":" + accountNumber + ":" + getTicker() + ":" + getTradeTimestamp().getTime() + ":" + fee; 
    }
}
