package com.lowes.repository.util;

import com.lowes.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();
        customer.setName(resultSet.getString("cname"));
        customer.setId(resultSet.getInt("cid"));
        return customer;
    }
}
