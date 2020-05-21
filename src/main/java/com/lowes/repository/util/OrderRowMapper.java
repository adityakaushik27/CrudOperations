package com.lowes.repository.util;
import com.lowes.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOid(resultSet.getInt("oid"));
        order.setCid(resultSet.getInt("cid"));
        order.setPid(resultSet.getInt("pid"));
        order.setQuantity(resultSet.getInt("quantity"));
//        order.setTimestamp(resultSet.getTimestamp("timestamp"));
        return order;
    }
}
