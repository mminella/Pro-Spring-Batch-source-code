package com.apress.springbatch.chapter10.partition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ColumnRangePartitioner extends JdbcTemplate implements Partitioner {

    private String column;
    private String table;
    private int gridSize;
    
    public Map<String, ExecutionContext> partition(int arg0) {
        int min = queryForInt("SELECT MIN(" + column + ") from "
                + table);
        int max = queryForInt("SELECT MAX(" + column + ") from "
                + table);
        int targetSize = (max - min) / gridSize;
System.out.println("Our partition size will be " + targetSize);
System.out.println("We will have " + gridSize + " partitions");
        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
        int number = 0;
        int start = min;
        int end = start + targetSize - 1;

        while (start <= max) {

            ExecutionContext value = new ExecutionContext();
            result.put("partition" + number, value);

            if (end >= max) {
                end = max;
            }
            value.putInt("minValue", start);
            value.putInt("maxValue", end);
System.out.println("minValue = " + start);            
System.out.println("maxValue = " + end);            
            start += targetSize;
            end += targetSize;
            number++;
        }
System.out.println("We are returning " + result.size() + " partitions");
        return result;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

}
