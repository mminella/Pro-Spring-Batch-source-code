package com.apress.springbatch.statement.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.jdbc.core.JdbcTemplate;

import com.apress.springbatch.statement.domain.AccountTransaction;

public class StagingChunkUpdater extends JdbcTemplate implements ItemWriteListener<AccountTransaction> {

    private String SQL = " set processed = true ";
    private String tableName;
    private String whereClause = "";
    
    public void beforeWrite(List<? extends AccountTransaction> items) {
    }

    public void afterWrite(List<? extends AccountTransaction> items) {
        for (AccountTransaction accountTransaction : items) {
            update("update " + tableName + SQL + whereClause, new Object[] {accountTransaction.getId()});
        }
    }

    public void onWriteError(Exception exception,
            List<? extends AccountTransaction> items) {
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }
}
