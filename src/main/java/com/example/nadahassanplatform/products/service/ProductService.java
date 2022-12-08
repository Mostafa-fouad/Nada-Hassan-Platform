package com.example.nadahassanplatform.products.service;

import com.example.nadahassanplatform.products.dto.ProductDto;

import java.util.UUID;

public interface ProductService {

    ProductDto getProductById(UUID id);

    void deleteProductById(UUID id);
}
