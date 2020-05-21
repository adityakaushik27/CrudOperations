package com.lowes.repository;

import com.lowes.model.Product;
import com.lowes.repository.util.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public Product updateProduct(Product product) {
        jdbcTemplate.update("update product pname = ? where pid = ?",product.getName(),product.getId());
        return product;
    }

    @Override
    public void deleteProduct(Integer pid) {
        NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        // Second parameter is of Object type so it can take any type of argument.
        Map<String,Object> paramMap = new HashMap<>();

        // For example, id here is of type Integer.
        paramMap.put("pid",pid);
        namedTemplate.update("delete from product where pid = :pid",paramMap);
    }
}
