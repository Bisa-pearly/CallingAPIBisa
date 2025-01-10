package com.calling.callingapiexception.service;
import com.calling.callingapiexception.models.Product;


import java.util.List;


public interface ProductService {
    Product getSingleProduct(long id);


    List<Product> getAllProducts();

    Product createProduct( String title, String description, Double price, String category);
}

