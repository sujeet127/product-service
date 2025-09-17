package com.scaler.productservice.service;

import com.scaler.productservice.dto.FakeStoreProductDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    RestTemplate restTemplate ;
    FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO =restTemplate.getForObject("https://fakestoreapi.com/products/{id}",FakeStoreProductDTO.class,id);

        if (fakeStoreProductDTO == null) {
            throw new ProductNotFoundException(id,"Product with id :"+ id+" not found.");
        }
        return convertFakeStoreToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO [] fakeStoreProductDTOS =restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDTO[].class);
        if (fakeStoreProductDTOS == null) {
            throw new RuntimeException("No records found.");
        }
        List<Product> resp = new ArrayList<>();
        for(FakeStoreProductDTO fsp:fakeStoreProductDTOS){
            Product res = convertFakeStoreToProduct(fsp);
            resp.add(res);
        }
        return resp;
    }

    private Product convertFakeStoreToProduct(FakeStoreProductDTO  fakeStoreProduct) {
        Product resp = new Product();
        resp.setCreatedAt(new Date());
        resp.setUpdatedAt(new Date());
        resp.setId(fakeStoreProduct.getId());
        resp.setTitle(fakeStoreProduct.getTitle());
        resp.setPrice(fakeStoreProduct.getPrice());
        resp.setCategory(fakeStoreProduct.getCategory());
        resp.setDescription(fakeStoreProduct.getDescription());
        resp.setImage(fakeStoreProduct.getImage());
        return resp;
    }
}
