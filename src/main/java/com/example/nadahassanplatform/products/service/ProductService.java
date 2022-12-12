package com.example.nadahassanplatform.products.service;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto getProductById(UUID id);

    void addProduct(CreateProductDto createProductDto);

    List<Product> getAllProductsSortedByShortDescription();
    void deleteProductById(UUID id);
}
