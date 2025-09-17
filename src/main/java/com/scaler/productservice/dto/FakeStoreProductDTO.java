package com.scaler.productservice.dto;

import lombok.Data;

@Data
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String  description;
    private String category;
    private String  image;
}
