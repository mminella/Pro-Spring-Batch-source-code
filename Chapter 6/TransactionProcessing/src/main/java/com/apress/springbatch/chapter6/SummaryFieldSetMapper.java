package com.apress.springbatch.chapter6;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class SummaryFieldSetMapper implements FieldSetMapper<FileSummary> {

    public FileSummary mapFieldSet(FieldSet fieldSet) throws BindException {
        FileSummary summary = new FileSummary();
        summary.setNumberOfRecords(fieldSet.readInt(0));
        return summary;
    }

}
