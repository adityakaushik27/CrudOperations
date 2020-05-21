package com.lowes.repository;

import com.lowes.model.Product;

import java.util.List;

public interface ProductRepository {

    Product createProduct(Product product);
    List<Product> getProducts();
}
