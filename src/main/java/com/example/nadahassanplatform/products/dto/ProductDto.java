package com.example.nadahassanplatform.products.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ProductDto {

    private UUID id;
    private String description;
    private List<String> images;
    private List<String> colors;

}
