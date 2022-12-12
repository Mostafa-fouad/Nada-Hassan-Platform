package com.example.nadahassanplatform.products.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CreateProductDto {
    @NotBlank
    private String shortDescription;
    @NotBlank
    private String description;
    @NotNull
    private String primaryImage;

    private List<String> secondaryImages;
    @NotNull
    private List<String> colors;
    @NotNull
    private String category;


}
