package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.mapper.OrderMapper;
import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.orders.model.Orders.Status;
import com.example.nadahassanplatform.orders.repository.OrderRepository;
import com.example.nadahassanplatform.orders.service.OrderService;
import com.example.nadahassanplatform.products.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::getOrderDto).toList();
    }

    @Override
    public List<OrderDto> getAllOrdersByStatus(final String status) {
        return orderRepository.findOrdersByOrderStatusIs(Status.valueOf(status)).stream()
                .map(orderMapper::getOrderDto)
                .toList();
    }

    @Override
    public List<Status> getAllStatus() {
        return Status.getAllStatus();
    }

    @Override
    public OrderDto getOrderByID(UUID orderID) {
        final Orders order = orderRepository.findById(orderID)
                .orElseThrow(() -> new NotFoundException(String.format("Order with id %s is not found", orderID)));

        return orderMapper.getOrderDto(order);
    }

    @Override
    public String addOrder(CreateOrderDto createOrderDto) {
        return orderRepository.save(orderMapper.mapCreateOrderDtoToOrderModel(createOrderDto)).getOrderSubmissionId();
    }

    @Override
    public void updateExistingOrder(OrderDto updatedOrder) {
        var orderID = updatedOrder.getOrderId();
        final Map<UUID, Integer> orderItemsMap = new HashMap<>();
        final Orders order = orderRepository.findById(orderID)
                .orElseThrow(() -> new NotFoundException(String.format("Order with id %s is not found", orderID)));

        if(Objects.nonNull(updatedOrder.getAddress())) order.setAddress(updatedOrder.getAddress());
        if(Objects.nonNull(updatedOrder.getMobileNumber())) order.setMobileNumber(updatedOrder.getMobileNumber());
        if(Objects.nonNull(updatedOrder.getOrderItems()))
        {
            updatedOrder.getOrderItems().forEach(orderItem -> orderItemsMap.put(orderItem.getProductDto().getId(), orderItem.getQuantity()));
            order.setOrderItems(orderItemsMap);
        }

        orderRepository.save(order);
    }
}
