package com.apress.springbatch.statement.reader;

import java.net.URI;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.apress.springbatch.statement.dao.TickerDao;

public class UrlReader implements ItemStreamReader<String> {

    private String host;
    private String path;
    private int curPage = -1;
    private int pageSize = 200;
    private TickerDao tickersDao;

    public String read() throws Exception, UnexpectedInputException,
            ParseException {
        
        HttpClient client = new DefaultHttpClient();

        String buildQueryString = buildQueryString();
        
        if(buildQueryString == null) {
            return null;
        }
        
        URI uri = new URI("http", host, path, buildQueryString, null);

        HttpGet get = new HttpGet(uri);
        
        HttpResponse response = client.execute(get);

        HttpEntity entity = response.getEntity();
        
        String stockPrices = IOUtils.toString(entity.getContent());
        stockPrices = StringUtils.strip(stockPrices);
        
        if(stockPrices != null && stockPrices.length() > 0) {
            return stockPrices;
        } else {
            return null;
        }
    }

    private String buildQueryString() throws Exception {
        List<String> tickers = tickersDao.getTickersPaged(curPage, pageSize);
        
        if(tickers == null || tickers.size() == 0) {
            return null;
        }

        StringBuilder tickerList = new StringBuilder("s=");
        
        for (String ticker : tickers) {
            tickerList.append(ticker + "+");
        }

        tickerList = new StringBuilder(tickerList.substring(0, tickerList.length() - 1));
        return tickerList.append("&f=sl1").toString();
    }

    public void close() throws ItemStreamException {
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {
        if(executionContext.containsKey("step2.tickers.page")) {
            curPage = (Integer) executionContext.get("step2.tickers.page");
        } else {
            executionContext.put("step2.tickers.page", curPage);
        }
    }

    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.put("step2.tickers.page", curPage);
        curPage++;
    }

    public void setTickersDao(TickerDao tickersDao) {
        this.tickersDao = tickersDao;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
