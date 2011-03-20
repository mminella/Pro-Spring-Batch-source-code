package com.apress.springbatch.statement.reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.domain.Address;
import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.PricingTier;
import com.apress.springbatch.statement.domain.Transaction;

public class CustomerStatementRowMapper implements RowMapper {

    public Customer mapRow(ResultSet resultSet, int arg1) throws SQLException {
        Customer customer = new Customer();
        
        customer.setFirstName(resultSet.getString("firstName"));
        customer.setLastName(resultSet.getString("lastName"));
        customer.setId(resultSet.getLong("customer_id"));
        
        customer.setAccount(buildAccount(resultSet, customer));
        customer.setAddress(buildAddress(resultSet));
        
        return customer;
    }

    private Account buildAccount(ResultSet resultSet, Customer customer) throws SQLException {
        Account account = new Account();
        
        account.setAccountNumber(resultSet.getString("accountNumber"));
        account.setCashBalance(resultSet.getBigDecimal("cashBalance"));
        account.setCust(customer);
        account.setTier(PricingTier.convert(resultSet.getInt("tier")));
        
        account.setTransactions(buildTransactionList(resultSet));
        
        return account;
    }

    private List<Transaction> buildTransactionList(ResultSet resultSet) throws SQLException{
        List<Transaction> transactions = new ArrayList<Transaction>();
        
        Transaction transaction = new Transaction();
        transaction.setAccountId(resultSet.getLong("account_id"));
        transaction.setDollarAmount(resultSet.getBigDecimal("fee"));
        transaction.setId(resultSet.getLong("transaction_id"));
        transaction.setQuantity(resultSet.getLong("qty"));
//        transaction.setTicker(resultSet.getString("ticker"));
        transaction.setTradeTimestamp(resultSet.getDate("executedTime"));
        
        transactions.add(transaction);
        
        return transactions;
    }

    private Address buildAddress(ResultSet resultSet) throws SQLException {
        Address address = new Address();
        
        address.setAddress1(resultSet.getString("address"));
        address.setCity(resultSet.getString("city"));
        address.setState(resultSet.getString("state"));
        address.setZip(resultSet.getString("zip"));
        
        return address;
    }

}
