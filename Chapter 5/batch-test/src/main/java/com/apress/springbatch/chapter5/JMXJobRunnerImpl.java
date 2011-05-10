package com.apress.springbatch.chapter5;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;

public class JMXJobRunnerImpl implements JMXJobRunner {

	private JobOperator operator;

	public void runJob(String name) throws NoSuchJobException,
			JobInstanceAlreadyExistsException, JobParametersInvalidException {
		try {
			operator.start(name, null);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public JobOperator getOperator() {
		return operator;
	}

	public void setOperator(JobOperator operator) {
		this.operator = operator;
	}
}
