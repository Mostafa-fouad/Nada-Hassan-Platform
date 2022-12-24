package com.example.nadahassanplatform.orders.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class CreateOrderDto {

    @NotNull
    private String email;
    @NotNull
    private String mobileNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    @NotNull
    private String address;
    @NotNull
    @NotEmpty
    private List<OrderItemDto> orderItems;
}
