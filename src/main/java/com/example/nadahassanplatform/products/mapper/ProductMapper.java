package com.example.nadahassanplatform.products.mapper;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapProductModelToProductDto(final Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .shortDescription(product.getShortDescription())
                .primaryImage(product.getPrimaryImage())
                .secondaryImages(product.getSecondaryImages())
                .colors(product.getColors())
                .category(product.getProductCategory().getValue())
                .build();
    }

    public Product mapCreateProductDtoToProductModel(final CreateProductDto createProductDto) {
        return  Product.builder()
                .shortDescription(createProductDto.getShortDescription())
                .description(createProductDto.getDescription())
                .primaryImage(createProductDto.getPrimaryImage())
                .secondaryImages(createProductDto.getSecondaryImages())
                .price(createProductDto.getPrice())
                .productCategory(Product.Category.valueOf(createProductDto.getCategory()))
                .colors(createProductDto.getColors()).build();
    }
}
