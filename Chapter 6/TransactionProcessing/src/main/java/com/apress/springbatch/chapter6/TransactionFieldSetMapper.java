package com.apress.springbatch.chapter6;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class TransactionFieldSetMapper implements FieldSetMapper<Transaction> {

    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        Transaction trans = new Transaction();
        trans.setAccountNumber(fieldSet.readString(0));
        trans.setTimestamp(fieldSet.readDate(1, "yyyy-MM-DD HH:mm:ss"));
        trans.setAmount(fieldSet.readDouble(2));
        
        return trans;
    }

}
