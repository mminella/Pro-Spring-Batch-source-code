package com.apress.springbatch.statement.listener;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.jdbc.core.JdbcTemplate;


public class StagingStepListener extends JdbcTemplate implements StepListener {
    
    private String SQL = " set jobId = ?, processed = false ";
    private String tableName;
    private String whereClause = "";
    private long jobId;
    
    @BeforeStep
    public void stageRecords() {
        update("update " + tableName + SQL + whereClause, new Object [] {jobId});
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public void setWhereClause(String whereClause) {
        if(whereClause != null) {
            this.whereClause = whereClause;
        }
    }
}
