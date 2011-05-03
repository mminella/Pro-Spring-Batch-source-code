package com.apress.springbatch.chapter7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    private String accountNumber;
    private Date transactionDate;
    private Double amount;
    
    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getDateString() {
        return formatter.format(transactionDate);
    }

}
