package com.apress.springbatch.chapter4;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

public class LoggingStepStartStopListener {
    
    @BeforeStep
    public void beforeStep(StepExecution execution) {
        System.out.println(execution.getStepName() + " has begun!");
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution execution) {
        System.out.println(execution.getStepName() + " has ended!");

       return execution.getExitStatus();
    }
}
