package com.example.nadahassanplatform.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@RequiredArgsConstructor
@Component
@Builder
@Validated
public class CreateProductDto {

    @NotBlank
    private final String description;

    @NotNull
    private final List<String> images;

    @NotNull
    private final List<String> colors;

}
