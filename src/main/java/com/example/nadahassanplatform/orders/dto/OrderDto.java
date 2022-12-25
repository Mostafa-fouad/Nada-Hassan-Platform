package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.orders.util.OrderProduct;
import lombok.*;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private UUID id;
    private String orderSubmissionId;
    private String address;
    private String customerMobile;
    private Map<UUID, OrderProduct> orderItems;
    private Instant createdDate;
    private Instant updatedDate;
}
