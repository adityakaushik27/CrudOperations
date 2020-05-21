package com.lowes.controller;

import com.lowes.model.Customer;
import com.lowes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public @ResponseBody Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @RequestMapping(value="/delete/{cid}",method = RequestMethod.DELETE)
    public @ResponseBody Object deleteCustomer(@PathVariable(value="cid") Integer cid){
        customerService.deleteCustomer(cid);
        return null;
    }
}
