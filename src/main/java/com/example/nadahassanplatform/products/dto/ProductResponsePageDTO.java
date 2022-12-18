package com.example.nadahassanplatform.products.dto;

import com.example.nadahassanplatform.utils.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponsePageDTO {

    @JsonProperty("content")
    private List<ProductDto> content = null;

    @JsonProperty("page")
    private PageDTO page;
}
