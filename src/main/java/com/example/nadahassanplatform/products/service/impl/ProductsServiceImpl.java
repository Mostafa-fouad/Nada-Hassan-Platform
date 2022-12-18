package com.example.nadahassanplatform.products.service.impl;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.dto.UpdateProductDto;
import com.example.nadahassanplatform.products.mapper.ProductMapper;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import com.example.nadahassanplatform.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public void addProduct(final CreateProductDto createProductDto)
    {
        var createdProduct = productMapper.mapCreateProductDtoToProductModel(createProductDto);
        productRepository.save(createdProduct);
    }

    @Override
    public void deleteProductById(final UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProductsSortedByShortDescription()
    {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "shortDescription")).stream()
                .map(productMapper::mapProductModelToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(final UpdateProductDto updateProductDto) {

        final Product product = productRepository.findById(updateProductDto.getId())
                .orElseThrow(() -> new NotFoundException (String.format("Product with id %s not found", updateProductDto.getId())));

        updateProductFields(product, updateProductDto);

        return productMapper.mapProductModelToProductDto(productRepository.save(product));
    }

    private void updateProductFields(final Product product, final UpdateProductDto updateProductDto) {

        if (Objects.nonNull(updateProductDto.getCategory()))
            product.setProductCategory(Product.Category.valueOf(updateProductDto.getCategory()));
        if (Objects.nonNull(updateProductDto.getDescription())) product.setDescription(updateProductDto.getDescription());
        if (Objects.nonNull(updateProductDto.getShortDescription())) product.setShortDescription(updateProductDto.getShortDescription());
        if (Objects.nonNull(updateProductDto.getColors())) product.setColors(updateProductDto.getColors());
        if (Objects.nonNull(updateProductDto.getPrimaryImage())) product.setPrimaryImage(updateProductDto.getPrimaryImage());
        if (Objects.nonNull(updateProductDto.getSecondaryImages())) product.setSecondaryImages(updateProductDto.getSecondaryImages());
        if (Objects.nonNull(updateProductDto.getPrice())) product.setPrice(updateProductDto.getPrice());
    }
}
