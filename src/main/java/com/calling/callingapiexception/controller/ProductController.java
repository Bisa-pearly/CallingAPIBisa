package com.calling.callingapiexception.controller;

import com.calling.callingapiexception.dto.FakeStoreProductDto;
import com.calling.callingapiexception.models.Product;
import com.calling.callingapiexception.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService ) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        System.out.println("i am start");
        Product p = productService.createProduct(product.getTitle(),
                product.getImageUrl(),
                product.getPrice(),
                product.getCategory().getTitle()
                );
        System.out.println("i am end");
        return p;
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
/*    @PutMapping("/Productss/")
    public Product updateProduct( @RequestBody FakeStoreProductDto fakeStoreProductDto) {
        System.out.println("i am start at Update PC");
        Product product=productService.updateProduct(
                id,
                fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getPrice(),
                fakeStoreProductDto.getCategory());

        System.out.println("i am Ending at Update PC");
        return product;
    }*/

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        System.out.println("start PC");
        return productService.updateProduct(
                id,
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle()

        );

    }

  /*  @DeleteMapping("/products/{id}")
    public Product deleteProductById(@PathVariable("id") Long id) {
        System.out.println("i am start at Delete");
        Product p = productService.deleteProduct(id);
        System.out.println("i am Ending at Delete");
        return p;
    }*/

    public String addProduct(Product product) {
        return "added successfully";

    }
}
