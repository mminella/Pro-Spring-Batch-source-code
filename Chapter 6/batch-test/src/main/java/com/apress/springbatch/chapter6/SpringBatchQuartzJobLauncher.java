package com.apress.springbatch.chapter6;

import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobParametersNotFoundException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SpringBatchQuartzJobLauncher extends QuartzJobBean {

    private JobLauncher jobLauncher;
    private JobLocator jobLocator;
    private JobExplorer jobExplorer;
    private Map<String, String> jobParameters;
    public static final String JOB_NAME = "jobName";

    private static final Logger log = LoggerFactory
            .getLogger(SpringBatchQuartzJobLauncher.class);

    @Override
    @SuppressWarnings("unchecked")
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        Map<String, Object> jobDataMap = context.getMergedJobDataMap();
        String jobName = (String) jobDataMap.get(JOB_NAME);

        try {
            Job job = jobLocator.getJob(jobName);
            JobParameters allParams = translateParams(job, jobParameters);

            jobLauncher.run(job, allParams);
        } catch (Exception e) {
            log.error("Could not execute job.", e);
        }
    }

    private JobParameters translateParams(Job job, Map<String, String> params)
            throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();

        JobParameters incrementedParams = getNextJobParameters(job);

        for (Map.Entry<String, JobParameter> param : incrementedParams
                .getParameters().entrySet()) {
            builder.addParameter(param.getKey(), param.getValue());
        }

        for (Map.Entry<String, String> param : params.entrySet()) {
            builder.addString(param.getKey(), param.getValue());
        }

        return builder.toJobParameters();
    }

    private JobParameters getNextJobParameters(Job job)
            throws JobParametersNotFoundException {
        String jobIdentifier = job.getName();
        JobParameters jobParameters;
        List<JobInstance> lastInstances = jobExplorer.getJobInstances(
                jobIdentifier, 0, 1);

        JobParametersIncrementer incrementer = job
                .getJobParametersIncrementer();
        if (incrementer == null) {
            throw new JobParametersNotFoundException(
                    "No job parameters incrementer found for job="
                            + jobIdentifier);
        }

        if (lastInstances.isEmpty()) {
            jobParameters = incrementer.getNext(new JobParameters());
            if (jobParameters == null) {
                throw new JobParametersNotFoundException(
                        "No bootstrap parameters found from incrementer for job="
                                + jobIdentifier);
            }
        } else {
            jobParameters = incrementer.getNext(lastInstances.get(0)
                    .getJobParameters());
        }
        return jobParameters;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJobLocator(JobLocator jobLocator) {
        this.jobLocator = jobLocator;
    }

    public void setJobParameters(Map<String, String> jobParameters) {
        this.jobParameters = jobParameters;
    }

    public void setJobExplorer(JobExplorer jobExplorer) {
        this.jobExplorer = jobExplorer;
    }
}
