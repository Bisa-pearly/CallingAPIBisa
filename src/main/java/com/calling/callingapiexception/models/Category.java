package com.calling.callingapiexception.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    private String title;

    //Constructor
    public Category() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
