package com.apress.springbatch.statement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.apress.springbatch.statement.dao.CustomerDao;
import com.apress.springbatch.statement.domain.Address;
import com.apress.springbatch.statement.domain.Customer;

public class CustomerDaoJdbc extends JdbcTemplate implements CustomerDao {

    private static final String FIND_BY_TAX_ID = "select * from customer c where ssn = ?";
    private static final String INSERT_CUSTOMER = "insert into customer (firstName, lastName, ssn, address1, city, state, zip) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "update customer set firstName = ?, lastName = ?, ssn = ?, address1 = ?, city = ?, state = ?, zip = ? where id = ?";

    @SuppressWarnings("unchecked")
    public Customer findCustomerByTaxId(String taxId) {
        List<Customer> customers = query(FIND_BY_TAX_ID,
                new Object[] { taxId }, new RowMapper() {

                    public Object mapRow(ResultSet rs, int arg1)
                            throws SQLException {
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

        if (customers != null && customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }

    public void saveCustomer(Customer customer) {
        if (customer.getId() >= 0) {
            update(UPDATE_CUSTOMER, new Object[] { customer.getFirstName(),
                    customer.getLastName(), customer.getTaxId(),
                    customer.getAddress().getAddress1(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getState(),
                    customer.getAddress().getZip(), customer.getId() });
        } else {
            update(INSERT_CUSTOMER, new Object[] { customer.getFirstName(),
                    customer.getLastName(), customer.getTaxId(),
                    customer.getAddress().getAddress1(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getState(),
                    customer.getAddress().getZip() });
        }
    }
}
