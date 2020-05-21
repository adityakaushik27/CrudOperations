package com.lowes.repository;

import com.lowes.model.Customer;
import com.lowes.repository.util.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Customer createCustomer(Customer customer) {

        String sql = "insert into customer (cname) values (?)";
        System.out.println(sql);
        int x = this.jdbcTemplate.update(sql,customer.getName());
        System.out.println("OUTPUT IS " + x);
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customers = jdbcTemplate.query("select * from customer", new CustomerRowMapper() {
        });
        return customers;
    }
}
