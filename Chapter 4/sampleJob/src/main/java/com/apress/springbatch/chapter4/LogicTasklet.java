package com.apress.springbatch.chapter4;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class LogicTasklet implements Tasklet {
    
    private boolean success;

    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
            throws Exception {
        if(success) {
            return RepeatStatus.FINISHED;
        } else {
            throw new RuntimeException("This will cause a failure");
        }
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
