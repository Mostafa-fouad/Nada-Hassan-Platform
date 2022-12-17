package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.products.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    @NotNull
    private String orderSubmissionId;
    @NotNull
    private String address;
    @NotNull
    private String customerMobile;
    private List<Product> orderItems;

}
