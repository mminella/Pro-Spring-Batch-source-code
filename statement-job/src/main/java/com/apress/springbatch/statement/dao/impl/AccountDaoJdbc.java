package com.apress.springbatch.statement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.dao.AccountDao;
import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.domain.Address;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.PricingTier;
import com.apress.springbatch.statement.domain.Transaction;
import com.apress.springbatch.statement.domain.TransactionType;

public class AccountDaoJdbc extends JdbcTemplate implements AccountDao {

    private final class AccountRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int arg1)
                throws SQLException {
            Account account = new Account();
            
            account.setAccountNumber(rs.getString("accountNumber"));
            account.setCashBalance(rs.getBigDecimal("cashBalance"));
            account.setTier(PricingTier.convert(rs.getInt("tier")));
            account.setId(rs.getLong("id"));
            account.setCust(buildCustomer(rs));
            account.setTransactions(buildTransactions(rs));
            
            return account;
        }

        private List<Transaction> buildTransactions(ResultSet rs) throws SQLException {
            List<Transaction> transactions = new ArrayList<Transaction>();

            do {
                if(rs.getLong("transaction_id") >= 0) {
                    Transaction curTransaction = new Transaction();
                    curTransaction.setAccountId(rs.getLong("id"));
                    curTransaction.setAccountNumber(rs.getString("accountNumber"));
                    curTransaction.setDollarAmount(rs.getBigDecimal("dollarAmount"));
                    curTransaction.setId(rs.getLong("transaction_id"));
                    curTransaction.setQuantity(rs.getLong("qty"));
                    curTransaction.setTickerId(rs.getLong("tickerId"));
                    curTransaction.setTradeTimestamp(rs.getDate("executedTime"));
                    curTransaction.setType(TransactionType.fromIntValue(rs.getInt("transactionType")));
                    
                    transactions.add(curTransaction);
                }
            } while(rs.next());
            
            if(transactions.size() > 0) {
                rs.previous();
            }
            
            return transactions;
        }

        private Customer buildCustomer(ResultSet rs) throws SQLException {
            Customer customer = new Customer();

            customer.setId(rs.getLong("customer_id"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setTaxId(rs.getString("ssn"));
            customer.setAddress(buildAddress(rs));

            return customer;
        }

        private Address buildAddress(ResultSet rs)
                throws SQLException {
            Address address = new Address();

            address.setAddress1(rs.getString("address1"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));

            return address;
        }
    }

    private static final String FIND_BY_ACCOUNT_NUMBER = "select a.id, a.accountNumber, a.cashBalance, a.tier, a.customer_id, c.firstName, c.lastName, c.ssn, c.address1, c.city, c.state, c.zip, t.id as transaction_id, t.transactionType, t.executedTime, t.dollarAmount, t.qty, t.tickerId, t.fee  from account a inner join customer c on a.customer_id = c.id left outer join transaction t on a.id = t.account_id where accountNumber = ?";
    private static final String LOAD_ACCOUNTS = "select a.id, a.accountNumber, a.cashBalance, a.tier, a.customer_id, c.firstName, c.lastName, c.ssn, c.address1, c.city, c.state, c.zip, t.id as transaction_id, t.transactionType, t.executedTime, t.dollarAmount, t.qty, t.tickerId, t.fee from account a inner join customer c on a.customer_id = c.id left outer join transaction t on a.id = t.account_id";
    private static final String INSERT_ACCOUNT = "insert into account (accountNumber, cashBalance, tier, Customer_id) values (?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT = "update account set accountNumber = ?, cashBalance = ?, tier = ?, Customer_id = ?  where id = ?";
    
    @SuppressWarnings("unchecked")
    public Account findAccountByNumber(String accountNumber) {
        List<Account> accounts = query(FIND_BY_ACCOUNT_NUMBER,
                new Object[] { accountNumber }, new AccountRowMapper());

        if (accounts != null && accounts.size() > 0) {
            return accounts.get(0);
        } else {
            return null;
        }
    }
    
    public void saveAccount(Account account) {
        if(account.getId() < 0) {
            update(INSERT_ACCOUNT, new Object [] {account.getAccountNumber(), account.getCashBalance(), account.getTier(), account.getCust().getId()});
        } else {
            update(UPDATE_ACCOUNT, new Object [] {account.getAccountNumber(), account.getCashBalance(), account.getTier(), account.getCust().getId(), account.getId()});
        }
    }

    @SuppressWarnings("unchecked")
    public List<Account> loadAccounts() {
        return (List<Account>) query(LOAD_ACCOUNTS, new AccountRowMapper());
    }
}
