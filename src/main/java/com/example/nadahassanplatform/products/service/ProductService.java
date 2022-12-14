package com.example.nadahassanplatform.products.service;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.dto.ProductResponsePageDTO;
import com.example.nadahassanplatform.products.dto.UpdateProductDto;
import com.example.nadahassanplatform.products.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto getProductById(UUID id);
    List<ProductDto> getProductsByCategory(Integer categoryId);
    List<Product.Category> getAllProductsCategories();
    void addProduct(CreateProductDto createProductDto);
    ProductResponsePageDTO getAllProductsPage(Pageable pageable);
    void deleteProductById(UUID id);
    void updateProduct(UpdateProductDto updateProductDto);
}
