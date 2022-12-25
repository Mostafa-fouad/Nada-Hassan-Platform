package com.example.nadahassanplatform.orders.util;

import com.example.nadahassanplatform.products.model.Product;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    @NotNull
    private Integer quantity;
    @NotNull
    private Product product;
}