package com.apress.springbatch.chapter9;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.core.io.Resource;

public class CustomerWriterWithFooter implements ResourceAwareItemWriterItemStream<Customer>,
        FlatFileFooterCallback {

    private ResourceAwareItemWriterItemStream<Customer> delegate;
    private int itemsProcessedSoFar = 0;
    
    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("At the end of this file, we have written " + itemsProcessedSoFar + " items");
    }

    @Override
    public void write(List<? extends Customer> items) throws Exception {
        itemsProcessedSoFar += items.size();
        
        delegate.write(items);
    }

    public void setDelegate(ResourceAwareItemWriterItemStream<Customer> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public void open(ExecutionContext arg0) throws ItemStreamException {
        delegate.open(arg0);
    }

    @Override
    public void update(ExecutionContext arg0) throws ItemStreamException {
        delegate.update(arg0);
    }

    @Override
    public void setResource(Resource arg0) {
        itemsProcessedSoFar = 0;
        delegate.setResource(arg0);
    }

}
