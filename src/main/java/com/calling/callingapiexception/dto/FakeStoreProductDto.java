package com.calling.callingapiexception.dto;

import com.calling.callingapiexception.models.Category;
import com.calling.callingapiexception.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //This will map the fake store implementation to my column or attributes name i defined.
    public Product getProducts(){
    Product product = new Product();
    product.setId(this.id);
    product.setTitle(this.title);
    product.setPrice(this.price);
    product.setDescription(this.description);
    product.setImageUrl(this.image);

    Category cat=new Category();
    cat.setTitle(this.category);
    product.setCategory(cat);
    return product;



    }



}
