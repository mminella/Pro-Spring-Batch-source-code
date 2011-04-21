package com.apress.springbatch.chapter2; 

import org.springframework.batch.core.StepContribution; 
import org.springframework.batch.core.scope.context.ChunkContext; 
import org.springframework.batch.core.step.tasklet.Tasklet; 
import org.springframework.batch.repeat.RepeatStatus; 

public class HelloWorld implements Tasklet { 

     private static final String HELLO_WORLD = "Hello, world!"; 

     public RepeatStatus execute( StepContribution arg0, ChunkContext arg1 ) throws Exception {
          System.out.println( HELLO_WORLD );
          return RepeatStatus.FINISHED; 
     } 
}
