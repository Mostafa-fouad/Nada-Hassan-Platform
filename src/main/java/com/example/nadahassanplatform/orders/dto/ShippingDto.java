package com.example.nadahassanplatform.orders.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingDto {

    private String governmentName;
    private Double fees;
}