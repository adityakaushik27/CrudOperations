package com.lowes.controller;

import com.lowes.model.Customer;
import com.lowes.model.Product;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CustomerControllerTest {

    @Test(timeout = 30000)
    public void testCreateCustomer(){
        RestTemplate restTemplate = new RestTemplate();

        Customer customer = new Customer();
        customer.setName("Aditi");

        Customer customer1 = restTemplate.postForObject("http://localhost:8040/crud_war/customer",customer,Customer.class);
        System.out.println("Customer : "+customer1.getName()+" added.");
    }

    @Test(timeout = 30000)
    public void testGetCustomers(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Customer>> customerResponse = restTemplate.exchange(
                "http://localhost:8040/crud_war/getCustomers", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Customer>>() {
                });

        List<Customer> customers = customerResponse.getBody();

        for (Customer customer:customers) {
            System.out.println("Customer name : "+customer.getName());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateCustomer(){
        RestTemplate restTemplate = new RestTemplate();

        Customer customer = restTemplate.getForObject("http://localhost:8050/crud_war/customer/1",Customer.class);

        customer.setName(customer.getName()+"Done");

        restTemplate.put("http://localhost:8050/crud_war/customer",customer);

        System.out.println("Customer name: "+ customer.getName());
    }

    @Test(timeout = 30000)
    public void testDeleteCustomer(){
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete("http://localhost:8050/crud_war/delete/4",Customer.class);
        System.out.println("Deleted Customer id: ");
    }

}
