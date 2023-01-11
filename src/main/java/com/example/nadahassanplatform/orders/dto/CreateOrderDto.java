package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.orders.util.OrderProduct;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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
