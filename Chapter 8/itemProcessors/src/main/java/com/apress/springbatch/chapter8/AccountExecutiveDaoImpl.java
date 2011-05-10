package com.apress.springbatch.chapter8;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AccountExecutiveDaoImpl extends JdbcTemplate implements
        AccountExecutiveDao {

    private String BY_CUSTOMER = "select a.* from accountExecutive a inner join customer c on a.id = c.accountExecutiveId where c.id = ?";
    
    public AccountExecutive getAccountExecutiveByCustomer(Customer customer) {
        return (AccountExecutive) queryForObject(BY_CUSTOMER, new Object [] {customer.getId()}, new RowMapper() {

            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                AccountExecutive result = new AccountExecutive();
                
                result.setFirstName(rs.getString("firstName"));
                result.setLastName(rs.getString("lastName"));
                result.setId(rs.getLong("id"));
                
                return result;
            }
        });
    }

}
