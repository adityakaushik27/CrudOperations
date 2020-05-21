package com.lowes.service;

import com.lowes.model.Product;
import com.lowes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
