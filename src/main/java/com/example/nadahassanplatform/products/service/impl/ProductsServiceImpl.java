package com.example.nadahassanplatform.products.service.impl;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.mapper.ProductMapper;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import com.example.nadahassanplatform.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = {"products-cache"})
@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductDto getProductById(final UUID id) {

        return productMapper.mapProductModelToProductDto(
                productRepository.findById(id).orElseThrow(
                        () -> new NotFoundException (String.format("Product with id %s is not found", id)))
        );
    }

    @Override
    public void addProduct(CreateProductDto createProductDto)
    {
        var createdProduct = productMapper.mapCreateProductDtoToProductModel(createProductDto);
        productRepository.save(createdProduct);
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProductsSortedByShortDescription()
    {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "shortDescription")).stream()
                .map(productMapper::mapProductModelToProductDto)
                .collect(Collectors.toList());
    }
}
