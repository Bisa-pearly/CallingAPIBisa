package com.calling.callingapiexception.service;
import com.calling.callingapiexception.models.Product;
import jdk.jfr.Category;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(long id);

    //Product getSingleProduct(Long id);

    List<Product> getAllProducts();
    //product createProduct(product product);
    //product createProduct(product product);

    Product createProduct( String title, String description, Double price, String category);
}

