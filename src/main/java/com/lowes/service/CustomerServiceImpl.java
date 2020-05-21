package com.lowes.service;

import com.lowes.model.Customer;
import com.lowes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
     return customerRepository.createCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
