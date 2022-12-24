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
    @NotNull
    private Double price;
    @NotNull
    private Integer categoryCode;
    @NotNull
    private List<String> colors;
    private List<String> secondaryImages;

}
