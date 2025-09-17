package com.scaler.productservice.service;

import com.scaler.productservice.dto.FakeStoreProductDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(final Long id) throws ProductNotFoundException;
    public List<Product>getAllProducts();
}
