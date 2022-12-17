package com.example.nadahassanplatform.orders.service;


import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
}
