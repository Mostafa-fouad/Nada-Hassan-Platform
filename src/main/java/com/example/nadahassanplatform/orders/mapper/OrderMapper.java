package com.example.nadahassanplatform.orders.mapper;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {



    public Order mapCreateOrderDtoToOrderModel(CreateOrderDto createOrderDto) {
        return Order.builder()
                .address(createOrderDto.getAddress())
                .orderSubmissionId(createOrderDto.getOrderSubmissionId())
                .customerMobile(createOrderDto.getCustomerMobile())
                .orderItems(createOrderDto.getOrderItems()).build();
    }
}
