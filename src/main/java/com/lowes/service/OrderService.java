package com.lowes.service;

import com.lowes.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrders();
}
