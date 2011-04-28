package com.apress.springbatch.chapter4;

import java.util.Random;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class RandomDecider implements JobExecutionDecider {
    
    private Random random = new Random();

    public FlowExecutionStatus decide(JobExecution jobExecution,
            StepExecution stepExecution) {

        if (random.nextBoolean()) {
            return new FlowExecutionStatus(FlowExecutionStatus.COMPLETED.getName());
        } else {
            return new FlowExecutionStatus(FlowExecutionStatus.FAILED.getName());
        }
    }
}
