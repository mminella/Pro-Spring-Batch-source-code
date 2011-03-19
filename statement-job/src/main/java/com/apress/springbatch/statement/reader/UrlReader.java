package com.apress.springbatch.statement.reader;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class UrlReader implements ItemReader<String> {

    private String host;
    private String path;
    private String stockPrices;

    public String read() throws Exception, UnexpectedInputException,
            ParseException {
//        HttpClient client = new DefaultHttpClient();
//
//        URI uri = URIUtils.createURI("http", host, -1, path,
//                buildQueryString(), null);
//
//        HttpGet get = new HttpGet(uri);
//
//        HttpResponse response = client.execute(get);
//
//        HttpEntity entity = response.getEntity();
//
//        if(stockPrices == null) {
//            stockPrices = IOUtils.toString(entity.getContent());
//            return StringUtils.strip(stockPrices);
//        } else {
            return null;
//        }
    }

//    private String buildQueryString() {
//        List<String> tickers = transactionDao.getStockTickers();
//
//        StringBuilder tickerList = new StringBuilder();
//        
//        for (String ticker : tickers) {
//            tickerList.append(ticker + "+");
//        }
//
//        List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
//        
//        queryParams.add(new BasicNameValuePair("s", tickerList.substring(0, tickerList.length() - 1)));
//        queryParams.add(new BasicNameValuePair("f", "sl1"));
//
//        return URLEncodedUtils.format(queryParams, "UTF-8");
//    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
