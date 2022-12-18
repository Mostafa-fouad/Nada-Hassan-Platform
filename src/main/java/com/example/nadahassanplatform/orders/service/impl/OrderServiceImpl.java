package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.model.Order;
import com.example.nadahassanplatform.orders.repository.OrderRepository;
import com.example.nadahassanplatform.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
