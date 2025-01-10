package com.calling.callingapiexception.service;

import com.calling.callingapiexception.dto.FakeStoreProductDto;
import com.calling.callingapiexception.models.Product;
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

}
