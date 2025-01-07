package com.calling.callingapiexception.service;

import com.calling.callingapiexception.dto.FakeStoreProductDto;
import com.calling.callingapiexception.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//We use @Service to let the java know this is special class so object can be created.
@Service("fakeStoreProductService")
public class FakestoreProductService implements ProductService{
    //@Autowired
    private final RestTemplate restTemplate;

    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   @Override
   public Product getSingleProduct(long id) {
/*        System.out.println(" Inside FK product service APi ");
        System.out.println(id);
        System.out.println("https://fakestoreapi.com/products/" + id);*/
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        System.out.println(fakeStoreProductDto.toString());
        //System.out.println(fakeStoreProductDto.getProducts());
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
        //fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);
        return response.getProducts();
    }
}
