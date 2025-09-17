package com.scaler.productservice.exception;

public class ProductNotFoundException extends Exception {
    private final Long id;
    public ProductNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
