package com.apress.springbatch.chapter4;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class ExampleJobListener {
    
    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("This listener was called at the beginning of our job");
    }

    @AfterJob
    public ExitStatus afterJob(JobExecution jobExecution) {
        System.out.println("This listener was called at the end of our job");
        
        return jobExecution.getExitStatus();
    }
}
