package com.scaler.productservice.dto;

import lombok.Data;

@Data
public class ProductNotFoundExceptionDTO {
    private Long id;
    private String message;
    private String resolution;
}
