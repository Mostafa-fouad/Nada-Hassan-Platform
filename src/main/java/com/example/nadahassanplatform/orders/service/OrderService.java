package com.example.nadahassanplatform.orders.service;


import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderDto> getAllOrders();

    OrderDto getOrderByID(UUID orderID);

    void addOrder(CreateOrderDto createOrderDto);
}
