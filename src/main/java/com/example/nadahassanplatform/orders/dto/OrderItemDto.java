package com.example.nadahassanplatform.orders.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    @NotNull
    private int quantity;
    @NotNull
    private UUID productId;
}