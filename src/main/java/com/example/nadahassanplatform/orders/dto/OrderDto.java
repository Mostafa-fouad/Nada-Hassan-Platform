package com.example.nadahassanplatform.orders.dto;

import com.example.nadahassanplatform.products.model.Product;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.List;
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

    private List<Product> orderItems;

    private Instant createdDate;

    private Instant updatedDate;
}
