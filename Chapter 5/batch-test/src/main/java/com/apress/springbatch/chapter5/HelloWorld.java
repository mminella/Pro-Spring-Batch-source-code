package com.apress.springbatch.chapter5;

import java.util.List;

import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorld implements Tasklet {

	private static final String HELLO = "Hello, %s!";
	private static final String WELCOME = "Welcome back %s!";
	private static final String JOB_NAME = "helloWorldJob";

	private JobExplorer explorer;

	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		List<JobInstance> executions = explorer
				.getJobInstances(JOB_NAME, 0, Integer.MAX_VALUE);
		String name = (String) chunkContext.getStepContext().getJobParameters()
				.get("name");

		if (executions.size() > 1) {
			System.out.println(String.format(WELCOME, name));
		} else {
			System.out.println(String.format(HELLO, name));
		}
		return RepeatStatus.FINISHED;
	}

	public JobExplorer getExplorer() {
		return explorer;
	}

	public void setExplorer(JobExplorer explorer) {
		this.explorer = explorer;
	}
}