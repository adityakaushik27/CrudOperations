package com.lowes.controller;

import com.lowes.model.Product;
import com.lowes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        List<Product> list =  productService.getProducts();
        System.out.println("Our list is : "+list);
        return list;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody
    Product createProduct(@RequestBody Product product) {
        Product product1 = productService.createProduct(product);
        if(product1==null){
            System.out.println("Output is null");
        }
        return product1;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public @ResponseBody Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @RequestMapping(value="/delete/{pid}",method = RequestMethod.DELETE)
    public @ResponseBody Object deleteProduct(@PathVariable(value="pid") Integer pid){
        productService.deleteProduct(pid);
        return null;
    }

}
