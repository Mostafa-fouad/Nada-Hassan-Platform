package com.example.nadahassanplatform.products.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UpdateProductDto {

    @NotNull
    private UUID id;
    private String description;
    private String shortDescription;
    private String primaryImage;
    private Double price;
    private List<String> secondaryImages;
    private List<String> colors;
    private String category;
}
