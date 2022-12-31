package com.example.nadahassanplatform.products.mapper;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.products.util.CategoryCodeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductDto mapProductModelToProductDto(final Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .shortDescription(product.getShortDescription())
                .price(product.getPrice())
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
                .quantity(createProductDto.getQuantity())
                .productCategory(Product.Category.valueOf(CategoryCodeMapper.getCategory(createProductDto.getCategoryCode()).getValue()))
                .colors(createProductDto.getColors()).build();
    }

    public List<ProductDto> mapListOfProductModelToListOfProductDto(final List<Product> products) {
        final List<ProductDto> productDtos = new ArrayList<>();

        products.forEach(product -> productDtos.add(mapProductModelToProductDto(product)));

        return productDtos;
    }
}
