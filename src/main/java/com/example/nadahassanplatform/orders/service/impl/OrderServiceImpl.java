package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.mapper.OrderMapper;
import com.example.nadahassanplatform.orders.repository.OrderRepository;
import com.example.nadahassanplatform.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDto.class)).toList();
    }
}
