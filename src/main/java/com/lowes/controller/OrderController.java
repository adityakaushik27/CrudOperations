package com.lowes.controller;
import com.lowes.model.Order;
import com.lowes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public @ResponseBody Order createOrder(@RequestBody Order order) {
        Order order1 = orderService.createOrder(order);
        if(order1==null){
            System.out.println("Output is null");
        }
        return order1;
    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrders() {
        List<Order> lst = orderService.getOrders();
        System.out.println("OUR LIST IS " + lst);
        return lst;
    }

}
