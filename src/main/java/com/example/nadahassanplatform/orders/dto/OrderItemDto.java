package com.example.nadahassanplatform.orders.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    @Min(1)
    @NotNull
    private Integer quantity;
    @NotNull
    private UUID productId;
}