package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.AddProductToOrderDto;
import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.mapper.OrderMapper;
import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.orders.model.Orders.Status;
import com.example.nadahassanplatform.orders.repository.OrderRepository;
import com.example.nadahassanplatform.orders.service.OrderService;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.orders.util.OrderProduct;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
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

    @Override
    public void addProductToExistingOrder(UUID id, AddProductToOrderDto addProductToOrderDto) {
        Orders existingOrder = orderRepository.findById(id).get();
        Map<UUID, Integer> existingOrderItems= existingOrder.getOrderItems();
        if(existingOrderItems.containsKey(addProductToOrderDto.getOrderItemId())){

            Integer currentQuantityOfProduct = existingOrderItems.get(addProductToOrderDto.getOrderItemId());
            existingOrderItems.put(addProductToOrderDto.getOrderItemId(),
                    currentQuantityOfProduct+ addProductToOrderDto.getQuantity());

        }else {
            Product productToBeAddedToExistingOrder = productRepository.findById(addProductToOrderDto.getOrderItemId()).get();
            existingOrderItems.put(addProductToOrderDto.getOrderItemId()
            ,addProductToOrderDto.getQuantity());



        }
        existingOrder.setOrderTotalAmount(existingOrder.getOrderTotalAmount()+
                productRepository.findById(addProductToOrderDto.getOrderItemId()).get().getPrice());

        orderRepository.save(existingOrder);
    }


}
