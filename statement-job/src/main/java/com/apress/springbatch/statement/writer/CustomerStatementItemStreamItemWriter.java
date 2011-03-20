package com.apress.springbatch.statement.writer;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.core.io.Resource;

import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.Transaction;

public class CustomerStatementItemStreamItemWriter implements
        ResourceAwareItemWriterItemStream<Customer> {
    
    private ResourceAwareItemWriterItemStream<Customer> bodyWriter;
    private ResourceAwareItemWriterItemStream<Transaction> detailWriter;
    
    public void close() throws ItemStreamException {
        bodyWriter.close();
        detailWriter.close();
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {
        bodyWriter.open(executionContext);
        detailWriter.open(executionContext);
    }

    public void update(ExecutionContext executionContext) throws ItemStreamException {
        bodyWriter.update(executionContext);
        detailWriter.update(executionContext);
    }

    public void write(List<? extends Customer> customers) throws Exception {
        bodyWriter.write(customers);
        detailWriter.write(customers.get(0).getAccount().getTransactions());
    }

    public void setResource(Resource resource) {
        bodyWriter.setResource(resource);
        detailWriter.setResource(resource);
    }

    public void setBodyWriter(ResourceAwareItemWriterItemStream<Customer> bodyWriter) {
        this.bodyWriter = bodyWriter;
    }

    public void setDetailWriter(
            ResourceAwareItemWriterItemStream<Transaction> detailWriter) {
        this.detailWriter = detailWriter;
    }
}
