package com.apress.springbatch.statement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.dao.AccountDao;
import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.domain.Address;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.PricingTier;

public class AccountDaoJdbc extends JdbcTemplate implements AccountDao {

    private static final String FIND_BY_ACCOUNT_NUMBER = "select * from account a inner join customer c on a.customer_id = c.id where accountNumber = ?";
    private static final String INSERT_ACCOUNT = "insert into account (accountNumber, cashBalance, tier, Customer_id) values (?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT = "update account set accountNumber = ?, cashBalance = ?, tier = ?, Customer_id = ?  where id = ?";
    
    @SuppressWarnings("unchecked")
    public Account findAccountByNumber(String accountNumber) {
        List<Account> accounts = query(FIND_BY_ACCOUNT_NUMBER,
                new Object[] { accountNumber }, new RowMapper() {

                    public Object mapRow(ResultSet rs, int arg1)
                            throws SQLException {
                        Account account = new Account();
                        
                        account.setAccountNumber(rs.getString("accountNumber"));
                        account.setCashBalance(rs.getBigDecimal("cashBalance"));
                        account.setTier(PricingTier.convert(rs.getInt("tier")));
                        account.setId(rs.getLong("id"));
                        account.setCust(buildCustomer(rs));
                        
                        return account;
                    }

                    private Customer buildCustomer(ResultSet rs) throws SQLException {
                        Customer customer = new Customer();

                        customer.setId(rs.getLong("id"));
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
                });

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
}
