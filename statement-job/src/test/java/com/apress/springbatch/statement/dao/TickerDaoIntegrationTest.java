package com.apress.springbatch.statement.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.apress.springbatch.statement.domain.Ticker;

@ContextConfiguration(locations = {"/test-context.xml"})
public class TickerDaoIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TickerDao tickerDao;
    
    @Test
    public void testTickerSaveRoundTrip() {
        Ticker ticker = new Ticker();
        ticker.setPrice(new BigDecimal("222.22"));
        ticker.setTicker("MTM");
        
        tickerDao.saveTicker(ticker);
        
        Ticker result = tickerDao.findTickerBySymbol("MTM");
        
        assertNotNull(result);
        assertEquals(222.22, result.getPrice().doubleValue(), 0);
        assertEquals("MTM", result.getTicker());
        assertTrue(result.getId() >= 0);
    }
}
