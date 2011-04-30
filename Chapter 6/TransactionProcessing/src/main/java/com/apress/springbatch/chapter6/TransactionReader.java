package com.apress.springbatch.chapter6;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.transform.FieldSet;

public class TransactionReader implements ItemReader<Object> {

    private ItemReader<FieldSet> fieldSetReader;
    private int recordCount = 0;
    private int expectedRecordCount = 0;

    public Object read() throws Exception, UnexpectedInputException, ParseException,
            NonTransientResourceException {
        Transaction record = process(fieldSetReader.read());

        return record;
    }

    private Transaction process(FieldSet fieldSet) {
        Transaction result = null;

        if(fieldSet.getFieldCount() > 1) {
            result = new Transaction();
            result.setAccountNumber(fieldSet.readString(0));
            result.setTimestamp(fieldSet.readDate(1, "yyyy-MM-DD HH:mm:ss"));
            result.setAmount(fieldSet.readDouble(2));

            recordCount++;
        } else {
            expectedRecordCount = fieldSet.readInt(0);
        }

        return result;
    }

    public void setFieldSetReader(ItemReader<FieldSet> fieldSetReader) {
        this.fieldSetReader = fieldSetReader;
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution execution) {
        System.out.println("++++++ record count = " + recordCount + " expected record count = " + expectedRecordCount);
        if(recordCount == expectedRecordCount) {
            return execution.getExitStatus();
        } else {
            return ExitStatus.STOPPED;
        }
    }
}
