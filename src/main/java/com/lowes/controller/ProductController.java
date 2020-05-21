package com.lowes.controller;

import com.lowes.model.Customer;
import com.lowes.model.Product;
import com.lowes.service.CustomerService;
import com.lowes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        List<Product> list =  productService.getProducts();
        System.out.println("Our list is : "+list);
        return list;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody
    Product createProduct(@RequestBody Product product) {
        Product product1 = productService.createProduct(product);
        if(product1==null){
            System.out.println("Output is null");
        }
        return product1;
    }


}
