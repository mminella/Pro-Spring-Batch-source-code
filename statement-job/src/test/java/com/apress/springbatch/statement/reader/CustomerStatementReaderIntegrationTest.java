package com.apress.springbatch.statement.reader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;

import org.springframework.batch.item.ItemStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"/test-context.xml"})
public class CustomerStatementReaderIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CustomerStatementReader customerStatementReader;
    
    @Before
    public void setUp() {
        ItemStream reader = (ItemStream) Whitebox.getInternalState(customerStatementReader, "customerReader");
        reader.open(null);
    }
    
    @Test
    public void testReadNoCustomers() throws Exception {
        assertNull(customerStatementReader.read());
    }
}
