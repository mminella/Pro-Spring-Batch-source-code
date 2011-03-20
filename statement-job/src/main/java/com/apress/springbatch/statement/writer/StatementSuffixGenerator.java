package com.apress.springbatch.statement.writer;

import org.springframework.batch.item.file.ResourceSuffixCreator;

public class StatementSuffixGenerator implements ResourceSuffixCreator {

    public String getSuffix(int arg0) {
        return arg0 + ".txt";
    }

}
