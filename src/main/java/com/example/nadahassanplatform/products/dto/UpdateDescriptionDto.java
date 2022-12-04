package com.example.nadahassanplatform.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UpdateDescriptionDto {

    @NotNull
    private UUID id;

    @NotBlank
    private String description;
}
