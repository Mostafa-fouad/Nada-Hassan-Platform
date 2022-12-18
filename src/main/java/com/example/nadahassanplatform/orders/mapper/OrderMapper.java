package com.example.nadahassanplatform.orders.mapper;

import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto mapOrderModelToOrderDto(final Order order) {

        return OrderDto.builder()
                .orderItems(order.getOrderItems())
                .orderSubmissionId(order.getOrderSubmissionId())
                .id(order.getId())
                .address(order.getAddress())
                .createdDate(order.getCreatedDate())
                .customerMobile(order.getCustomerMobile())
                .updatedDate(order.getUpdatedDate()).build();
    }
}
