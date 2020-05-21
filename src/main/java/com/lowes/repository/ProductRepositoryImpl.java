package com.lowes.repository;

import com.lowes.model.Product;
import com.lowes.repository.util.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product createProduct(Product product) {

        String sql = "insert into product (pname) values(?)";

        int x = jdbcTemplate.update(sql,product.getName());
        return product;
    }

    @Override
    public List<Product> getProducts() {

        List<Product>  products = jdbcTemplate.query("select * from product", new ProductRowMapper());
        return  products;
    }
}
