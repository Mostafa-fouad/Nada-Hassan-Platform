package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.products.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    @NotNull
    private String address;
    @NotNull
    private String mobileNumber;
    private List<UUID> orderItems;

}
