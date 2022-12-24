package com.example.nadahassanplatform.orders.util;

import com.example.nadahassanplatform.products.model.Product;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    private int quantity;
    private Product product;
}