package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.orders.model.Orders.Status;
import com.example.nadahassanplatform.orders.util.OrderProduct;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class OrderDto {

    private UUID id;
    private String orderSubmissionId;
    private String firstName;
    private String lastName;
    private String city;
    private String government;
    private String address;
    private String mobileNumber;
    private Map<UUID, OrderProduct> orderItems;
    private Instant createdDate;
    private Instant updatedDate;
    private double shippingFees;
    private double orderTotalAmount;
    private Status orderStatus;
}
