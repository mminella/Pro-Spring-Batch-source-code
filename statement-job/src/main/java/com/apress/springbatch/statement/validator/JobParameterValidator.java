package com.apress.springbatch.statement.validator;

import org.springframework.batch.core.*;
import java.util.Date;

public class JobParameterValidator implements JobParametersValidator{
	
    public void validate(JobParameters params) throws JobParametersInvalidException {
        Date runDate = params.getDate("statement.runDate");
		
		if(runDate == null) {
			throw new JobParametersInvalidException("No date was received!");
		}
    }
}
