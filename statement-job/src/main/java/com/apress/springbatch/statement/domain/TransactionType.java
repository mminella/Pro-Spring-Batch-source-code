package com.apress.springbatch.statement.domain;

public enum TransactionType {
    STOCK(0), UNDEFINED(-1);
    
    private int value;
    
    private TransactionType(int value) {
        this.value = value;
    }
    
    public int getIntValue() {
        return value;
    }
    
    public static TransactionType fromIntValue(int value) {
        switch (value) {
        case 0:
            return STOCK;
        default:
            return UNDEFINED;
        }
    }
}
