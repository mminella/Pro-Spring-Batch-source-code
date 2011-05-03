package com.apress.springbatch.chapter7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FieldSetFactory;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class CustomerFileLineTokenizer implements LineTokenizer {

    private String delimiter;
    private String names;
    private FieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();

    public FieldSet tokenize(String record) {
        
        String[] fields = record.split(delimiter);

        List<String> parsedFields = new ArrayList<String>();

        for (int i = 0; i < fields.length; i++) {
            if (i == 4) {
                parsedFields.set(i - 1, parsedFields.get(i - 1) + " " + fields[i]);
            } else {
                parsedFields.add(fields[i]);
            }
        }
        
        FieldSet fieldSet = fieldSetFactory.create(parsedFields.toArray(new String [0]), names.split(","));
        
        return fieldSet;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    
    public void setNames(String names) {
        this.names = names;
    }

}
