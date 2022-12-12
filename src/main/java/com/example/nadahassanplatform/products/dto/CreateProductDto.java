package com.example.nadahassanplatform.products.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CreateProductDto {
    @NotBlank
    private String short_description;
    @NotBlank
    private String description;
    @NotNull
    private String image;
    private List<String> images;
    @NotNull
    private List<String> colors;

}
