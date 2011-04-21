package com.apress.springbatch.chapter2; 

import org.springframework.batch.core.StepContribution; 
import org.springframework.batch.core.scope.context.ChunkContext; 
import org.springframework.batch.core.step.tasklet.Tasklet; 
import org.springframework.batch.repeat.RepeatStatus; 

/**
* The HelloWorld tasklet is used to write out a simple message to 
* standard out durring the processing of your job.
*/
public class HelloWorld implements Tasklet { 

     private static final String HELLO_WORLD = "Hello, world!"; 

	 /**
	 * {@inheritDoc}
	 */
     @Override
     public RepeatStatus execute( StepContribution arg0, ChunkContext arg1 ) throws Exception {
          System.out.println( HELLO_WORLD );
          return RepeatStatus.FINISHED; 
     } 
}
