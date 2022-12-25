package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.mapper.OrderMapper;
import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.orders.model.Orders.Status;
import com.example.nadahassanplatform.orders.repository.OrderRepository;
import com.example.nadahassanplatform.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orders -> modelMapper.map(orders, OrderDto.class)).toList();
    }

    @Override
    public List<OrderDto> getAllOrdersByStatus(final String status) {
        return orderRepository.findOrdersByOrderStatusIs(Status.valueOf(status)).stream()
                .map(orders -> modelMapper.map(orders, OrderDto.class))
                .toList();
    }

    @Override
    public List<Status> getAllStatus() {
        return Status.getAllStatus();
    }

    @Override
    public OrderDto getOrderByID(UUID orderID) {
        final Orders orders = orderRepository.findById(orderID)
                .orElseThrow(() -> new NotFoundException(String.format("Order with id %s is not found", orderID)));

        return modelMapper.map(orders, OrderDto.class);
    }

    @Override
    public void addOrder(CreateOrderDto createOrderDto) {
        orderRepository.save(orderMapper.mapCreateOrderDtoToOrderModel(createOrderDto));
    }
}
