package com.apress.springbatch.statement.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.dao.TickerDao;
import com.apress.springbatch.statement.domain.Ticker;
import com.apress.springbatch.statement.domain.Transaction;

public class TickerDaoJdbc extends JdbcTemplate implements TickerDao {
    
    private static final String FIND_BY_SYMBOL = "select * from ticker t where ticker = ?";
    private static final String SAVE_TICKER = "insert into ticker (ticker, currentPrice) values (?,?)";
    private static final String FIND_ALL = "select distinct ticker from ticker order by ticker limit ?, ?";
    private static final String TOTAL_VALUE = "select SUM(value) as totalValue " +
                                              "from (select ticker, qty * currentPrice as value " +
                                                    "from (select tk.ticker, SUM(ts.qty) as qty, tk.currentPrice " + 
                                                          "from transaction ts inner join " +
                                                               "ticker tk on ts.tickerId = tk.id inner join " + 
                                                               "account a on ts.account_id = a.id inner join " +
                                                               "customer c on c.id = a.customer_id " +
                                                           "where c.id = ? " +
                                                           "group by tk.ticker, tk.currentPrice) as stocks) as total";
    private static final String STOCKS_BY_CUSTOMER = "select ticker, qty, qty * currentPrice as value " +
                                                     "from (select tk.ticker, SUM(ts.qty) as qty, tk.currentPrice " +
                                                           "from transaction ts inner join  " +
                                                                "ticker tk on ts.tickerId = tk.id inner join  " +
                                                                "account a on ts.account_id = a.id inner join " +
                                                                "customer c on c.id = a.customer_id " +
                                                           "where c.id = ? " +
                                                           "group by tk.ticker, tk.currentPrice) as stocks";
    
    @SuppressWarnings("unchecked")
    public Ticker findTickerBySymbol(String symbol) {
        List<Ticker> tickers = query(FIND_BY_SYMBOL, new Object [] {symbol}, new RowMapper() {

            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Ticker ticker = new Ticker();
                
                ticker.setId(rs.getLong("id"));
                ticker.setPrice(rs.getBigDecimal("currentPrice"));
                ticker.setTicker(rs.getString("ticker"));
                
                return ticker;
            }
        });
        
        if(tickers != null && tickers.size() > 0) {
            return tickers.get(0);
        } else {
            return null;
        }
    }

    public void saveTicker(Ticker ticker) {
        update(SAVE_TICKER, new Object [] {ticker.getTicker(), ticker.getPrice()});
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getTickersPaged(int page, int pageSize) {
        return queryForList(FIND_ALL, new Object [] {(page * pageSize), pageSize}, String.class);
    }

    public BigDecimal getTotalValueForCustomer(long id) {
        BigDecimal result = (BigDecimal) queryForObject(TOTAL_VALUE, new Object [] {id}, BigDecimal.class);
        
        if(result == null) {
            result = new BigDecimal("0");
        }
        
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<Transaction> getStocksForCustomer(long id) {
        return query(STOCKS_BY_CUSTOMER, new Object [] {id}, new RowMapper() {

            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Transaction transaction = new Transaction();

                transaction.setDollarAmount(rs.getBigDecimal("value"));
                transaction.setQuantity(rs.getLong("qty"));
                transaction.setTicker(rs.getString("ticker"));
                
                return transaction;
            }
        });
    }
}
