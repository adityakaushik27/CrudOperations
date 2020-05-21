package com.lowes.controller;

import com.lowes.model.Product;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductControllerTest {

    @Test(timeout = 30000)
    public void testCreateProduct(){
        RestTemplate restTemplate = new RestTemplate();

        Product product = new Product();
        product.setName("Laptop");

        Product product1 = restTemplate.postForObject("http://localhost:8040/crud_war/product",product,Product.class);
        System.out.println("Customer : "+product1.getName()+" added.");
    }

    @Test(timeout = 30000)
    public void testGetProducts(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> productResponse = restTemplate.exchange(
                "http://localhost:8040/crud_war/getProducts", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Product>>() {
                });

        List<Product> products = productResponse.getBody();

        for (Product product:products) {
            System.out.println("Customer name : "+product.getName());
        }
    }
}
