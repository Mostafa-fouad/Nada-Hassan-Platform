package com.example.nadahassanplatform.products.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID id;
    private String shortDescription;
    private String description;
    private String primaryImage;
    private String category;
    private Double price;
    private List<String> secondaryImages;
    private List<String> colors;

}
