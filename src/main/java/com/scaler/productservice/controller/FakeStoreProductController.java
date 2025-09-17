package com.scaler.productservice.controller;

import com.scaler.productservice.dto.FakeStoreProductDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class FakeStoreProductController {
    ProductService productService;
    FakeStoreProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Product res=productService.getProductById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);


    }
    @RequestMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> resp = productService.getAllProducts();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
