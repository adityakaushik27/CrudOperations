package com.lowes.repository;

import com.lowes.model.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer createCustomer(Customer customer);
    List<Customer> getCustomers();

    void deleteCustomer(Integer cid);

    Customer updateCustomer(Customer customer);
}
