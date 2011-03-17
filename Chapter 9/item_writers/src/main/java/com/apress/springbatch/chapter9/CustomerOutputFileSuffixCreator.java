package com.apress.springbatch.chapter9;

import org.springframework.batch.item.file.ResourceSuffixCreator;

public class CustomerOutputFileSuffixCreator implements ResourceSuffixCreator {

    @Override
    public String getSuffix(int arg0) {
        return arg0 + ".xml";
    }

}
