package com.lowes.repository;

import com.lowes.model.Order;
import com.lowes.repository.util.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Order createOrder(Order order) {

        String sql = "insert into project.order (cid,pid,quantity) values (?,?,?)";

        int x = jdbcTemplate.update(sql,order.getCid(),order.getPid(),order.getQuantity());
        System.out.println("Order added successfully");
        return order;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orders = jdbcTemplate.query("select * from project.order",new OrderRowMapper());
        return orders;
    }
}
