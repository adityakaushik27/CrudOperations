package com.lowes.repository;

import com.lowes.model.Order;

import java.util.List;

public interface OrderRepository {

    Order createOrder(Order order);
    List<Order> getOrders();
}
