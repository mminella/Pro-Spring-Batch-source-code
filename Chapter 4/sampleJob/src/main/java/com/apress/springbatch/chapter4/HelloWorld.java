package com.apress.springbatch.chapter4; 

import org.springframework.batch.core.StepContribution; 
import org.springframework.batch.core.scope.context.ChunkContext; 
import org.springframework.batch.core.step.tasklet.Tasklet; 
import org.springframework.batch.repeat.RepeatStatus; 
import org.springframework.batch.item.ExecutionContext;

public class HelloWorld implements Tasklet { 

    private static final String HELLO_WORLD = "Hello, %s"; 

    private String name;

    public RepeatStatus execute( StepContribution step, ChunkContext context ) throws Exception {
	    String name = (String) context.getStepContext().getJobParameters().get("name");

		ExecutionContext jobContext = context.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
		
		jobContext.put("user.name", name);
		
//		throw new Exception ("Awww crap");
		
        System.out.println( String.format(HELLO_WORLD, name) );

        return RepeatStatus.FINISHED; 
    } 

    public void setName(String newName) {
	    name = newName;
    }

    public String getName() {
	    return name;
    }
}