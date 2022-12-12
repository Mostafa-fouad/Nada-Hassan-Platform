package com.example.nadahassanplatform.products.mapper;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductDto mapProductModelToProductDto(final Product product) {

//        TODO update this return after database & entity class creation
        return ProductDto.builder()
                .id(product.getId())
                .description("asdasd")
                .images(List.of())
                .colors(List.of()).build();
    }

    public Product mapCreateProductDtoToProductModel(final CreateProductDto CreateProductDto)
    {
        return  Product.builder()
                .shortDescription(CreateProductDto.getShort_description())
                .description(CreateProductDto.getDescription())
                .primaryImage(CreateProductDto.getImage())
                .secondaryImages(CreateProductDto.getImages())
                .colors(CreateProductDto.getColors()).build();
    }
}
