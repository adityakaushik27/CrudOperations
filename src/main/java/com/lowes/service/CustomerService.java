package com.lowes.service;

import com.lowes.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    List<Customer> getCustomers();
}
