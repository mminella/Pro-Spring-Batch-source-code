package com.apress.springbatch.statement.domain;

public class AccountTransactionQuantity {

    private String accountNumber;
    private long transactionCount;
    private PricingTier tier;
    
    public PricingTier getTier() {
        return tier;
    }
    public void setTier(PricingTier tier) {
        this.tier = tier;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public long getTransactionCount() {
        return transactionCount;
    }
    public void setTransactionCount(long transactionCount) {
        this.transactionCount = transactionCount;
    }
    @Override
    public String toString() {
        return accountNumber + " has " + transactionCount + " transactions this month wich falls into tier " + tier;
    }
}
