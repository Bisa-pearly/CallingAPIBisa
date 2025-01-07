package com.calling.callingapiexception.controller;

import com.calling.callingapiexception.models.Product;
import com.calling.callingapiexception.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;
    /*public ProductController(ProductService productService) {
        this.productService = productService;
    }*/
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService ) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        System.out.println("i am start");
        /*Product p = productService.createProduct(product.getId(),
                product.getTitle(), product.getDescription(),
                product.getPrice(), product.getCategory().getTitle());*/
        Product p = productService.createProduct(
                product.getTitle(), product.getDescription(),
                product.getImageUrl(),
                product.getPrice(), product.getCategory().getTitle());

        return p;
        System.out.println("i am end");
       // return null;

    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("i am start at APi");
        //System.out.println(id);
        Product p =productService.getSingleProduct(id);
        System.out.println("i am Ending at APi");
        System.out.println(p);
        return p;
    }
    public void updateProduct(@RequestBody Product product) {

    }
    public void deleteProductById(@RequestBody Product product) {

    }

    public String addProduct(Product product) {
        return "added successfully";
    }

}
