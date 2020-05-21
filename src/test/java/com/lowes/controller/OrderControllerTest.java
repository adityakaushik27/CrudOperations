package com.lowes.controller;

import com.lowes.model.Customer;
import com.lowes.model.Order;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OrderControllerTest {


    @Test(timeout = 30000)
    public void createOrderTest(){

        RestTemplate restTemplate = new RestTemplate();

        Order order = new Order();
        order.setCid(4);
        order.setPid(1);
        order.setQuantity(4);

        Order order1 = restTemplate.postForObject("http://localhost:8040/crud_war/order?cid=1&pid=12",order,Order.class);
        System.out.println("Order ID : "+order.getOid()+" added!");
    }

    @Test(timeout = 30000)
    public void getOrdersTest(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Order>> orderResponse = restTemplate.exchange(
                "http://localhost:8040/crud_war/getOrders", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Order>>() {
                });

        List<Order> orders = orderResponse.getBody();

        for (Order order:orders) {
            System.out.println("Order Id : "+order.getOid());
        }
    }

}
