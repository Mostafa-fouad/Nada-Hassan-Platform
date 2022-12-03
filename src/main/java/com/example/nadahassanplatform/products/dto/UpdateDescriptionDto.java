package com.example.nadahassanplatform.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UpdateDescriptionDto {

    @NotNull
    private UUID id;
    @NotBlank
    private String description;
}
