package com.calling.callingapiexception.service;

import com.calling.callingapiexception.dto.FakeStoreProductDto;
import com.calling.callingapiexception.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

//We use @Service to let the java know this is special class so object can be created.
@Service("fakeStoreProductService")
public class FakestoreProductService implements ProductService{

    private RestTemplate restTemplate;


    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Get single product
   @Override
   public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        System.out.println(fakeStoreProductDto.toString());
        return fakeStoreProductDto.getProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        if (response != null) {
            for (FakeStoreProductDto dto : response) {
                products.add(dto.getProducts());
            }
        }
        return products;
    }

    //Create Product

    @Override
    public Product createProduct(String title, String description, Double price, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);


        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );

        return null;
    }

    @Override
    public Product updateProduct(long id, String title, String description, Double price, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        System.out.println("start at updateProduct");
        ResponseEntity<FakeStoreProductDto> updateResponse = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(fakeStoreProductDto),
                FakeStoreProductDto.class
        );
        System.out.println(id +" i passed update");

        FakeStoreProductDto updatedProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );
        System.out.println(id +"i am Update end");
        return getSingleProduct(id);
    }

    @Override
    public Product deleteProduct(long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        return null;
    }

}
