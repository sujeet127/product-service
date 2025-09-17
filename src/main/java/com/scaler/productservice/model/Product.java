package com.scaler.productservice.model;


import lombok.Data;

@Data
public class Product extends  BaseModel {

    private String title;
    private Double price;
    private String  description;
    private String category;
    private String  image;
}
