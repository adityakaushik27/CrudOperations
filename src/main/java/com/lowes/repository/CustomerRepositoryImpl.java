package com.lowes.repository;

import com.lowes.model.Customer;
import com.lowes.repository.util.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public void deleteCustomer(Integer cid) {
        NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        // Second parameter is of Object type so it can take any type of argument.
        Map<String,Object> paramMap = new HashMap<>();

        // For example, id here is of type Integer.
        paramMap.put("cid",cid);
        namedTemplate.update("delete from customer where cid = :cid",paramMap);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        jdbcTemplate.update("update customer cname = ? where cid = ?",customer.getName(),customer.getId());
        return customer;
    }
}
