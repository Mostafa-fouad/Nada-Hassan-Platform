package com.example.nadahassanplatform.orders.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import java.util.List;


@Setter
@Getter
public class CreateOrderDto {

    @NotNull
    private String address;
    @NotNull
    private String mobileNumber;
    private List<OrderItemDto> orderItems;
}
