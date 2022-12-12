package com.example.nadahassanplatform.products.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ProductDto {

    private UUID id;
    private String shortDescription;
    private String description;
    private String primaryImage;
    private String category;
    private List<String> secondaryImages;
    private List<String> colors;

}
