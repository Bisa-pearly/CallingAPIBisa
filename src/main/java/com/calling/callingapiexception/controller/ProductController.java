package com.calling.callingapiexception.controller;

import com.calling.callingapiexception.dto.FakeStoreProductDto;
import com.calling.callingapiexception.models.Product;
import com.calling.callingapiexception.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService ) {
        this.productService = productService;
    }
// 1. Create API
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
//2. get single product APi
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("i am start at APi");
        //System.out.println(id);
        Product p =productService.getSingleProduct(id);
        System.out.println("i am Ending at APi");
        System.out.println(p);
        return p;
    }
//3. Update API
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
// 4. Delete API
   @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        System.out.println("i am start at Delete");
        System.out.println("Deleting product with ID: " + id);  // Add logging
        productService.deleteProduct(id);
        return "Deleted product with ID: " + id;
    }
    public String addProduct(Product product) {
        return "added successfully";

    }
// 5. get all product
    @GetMapping/*("/product")*/
    public List<Product> getAllProducts() {
        System.out.println("Getting all products");
        return productService.getAllProducts();
    }

}
