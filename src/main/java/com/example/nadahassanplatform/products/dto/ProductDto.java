package com.example.nadahassanplatform.products.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Builder
public class ProductDto {

    private final UUID id;
    private final String description;
    private final List<String> images;
    private final List<String> colors;

}
