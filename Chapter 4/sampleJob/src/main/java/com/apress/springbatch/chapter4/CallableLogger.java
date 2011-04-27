package com.apress.springbatch.chapter4;

import java.util.concurrent.Callable;

import org.springframework.batch.repeat.RepeatStatus;

public class CallableLogger implements Callable<RepeatStatus> {

    public RepeatStatus call() throws Exception {
        System.out.println("This was executed in another thread");
        
        return RepeatStatus.FINISHED;
    }
}
