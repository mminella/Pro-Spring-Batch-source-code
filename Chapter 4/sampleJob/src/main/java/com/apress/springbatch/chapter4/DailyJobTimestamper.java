package com.apress.springbatch.chapter4;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DailyJobTimestamper implements JobParametersIncrementer {

	/**
	 * Increment the current.date parameter.
	 */
	public JobParameters getNext( JobParameters parameters ) {
		Date today = new Date();
		if ( parameters != null && !parameters.isEmpty() ) {
			Date oldDate = parameters.getDate( "current.date", new Date() );
			today = DateUtils.addDays(oldDate, 1);
		}
		return new JobParametersBuilder().addDate( "current.date", today ).toJobParameters();
	}
}
