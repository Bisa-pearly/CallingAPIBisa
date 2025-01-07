package com.calling.callingapiexception.service;
import com.calling.callingapiexception.models.Product;
import jdk.jfr.Category;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(long id);

    List<Product> getAllProducts();
    //product createProduct(product product);
    //product createProduct(product product);

    Product createProduct(Long id, String title, String description, Double price, String category);

    Product createProduct(Long id, String title, String description, Double price, Category category);
}

