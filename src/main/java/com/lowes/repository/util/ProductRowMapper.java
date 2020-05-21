package com.lowes.repository.util;

import com.lowes.model.Customer;
import com.lowes.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("pid"));
        product.setName(resultSet.getString("pname"));
        return product;
    }
}
