package com.lowes.service;

import com.lowes.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getProducts();
    Product updateProduct(Product product);
    void deleteProduct(Integer pid);
}
