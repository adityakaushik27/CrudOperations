package com.lowes.controller;

import com.lowes.model.Customer;
import com.lowes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> getCustomers() {

        List<Customer> lst=customerService.getCustomers();
        System.out.println("OUR LIST IS " + lst);
        return lst;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.createCustomer(customer);
        if(customer1==null){
            System.out.println("Output is null");
        }
        return customer1;
    }
}
