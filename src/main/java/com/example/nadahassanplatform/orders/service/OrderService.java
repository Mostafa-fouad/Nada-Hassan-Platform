package com.example.nadahassanplatform.orders.service;


import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.model.Orders.Status;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderDto> getAllOrders();
    List<OrderDto> getAllOrdersByStatus(String status);
    List<Status> getAllStatus();
    OrderDto getOrderByID(UUID orderID);
    String addOrder(CreateOrderDto createOrderDto);
    void updateExistingOrder(OrderDto updatedOrder);
}
