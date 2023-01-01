package com.example.nadahassanplatform.orders.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Setter
@Getter
@Builder
public class AddProductToOrderDto {

    @NotNull
    private UUID orderItemId;

    @Positive
    private Integer quantity;
}
