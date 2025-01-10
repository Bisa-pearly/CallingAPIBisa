package com.calling.callingapiexception.models;

import lombok.AllArgsConstructor;


import java.util.List;

//@NoArgsConstructor
@AllArgsConstructor

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
