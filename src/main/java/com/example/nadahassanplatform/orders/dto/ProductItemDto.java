package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.products.dto.ProductDto;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemDto {

    private ProductDto productDto;
    private Integer quantity;
}
