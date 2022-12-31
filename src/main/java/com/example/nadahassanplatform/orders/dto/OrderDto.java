package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.orders.model.Orders.Status;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private UUID orderId;
    private String orderSubmissionId;
    private String firstName;
    private String lastName;
    private String city;
    private String government;
    private String address;
    private String mobileNumber;
    private List<ProductItemDto> orderItems;
    private Instant createdDate;
    private Instant updatedDate;
    private double shippingFees;
    private double orderTotalAmount;
    private Status orderStatus;
}
