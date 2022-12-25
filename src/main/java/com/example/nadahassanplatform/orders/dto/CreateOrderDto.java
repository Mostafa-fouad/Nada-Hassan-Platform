package com.example.nadahassanplatform.orders.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Setter
@Getter
public class CreateOrderDto {

    @NotBlank
    private String email;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String government;
    @NotBlank
    private String address;
    @NotEmpty
    @Valid
    private List<OrderItemDto> orderItems;
    private String city;
}
