package com.example.nadahassanplatform.orders.mapper;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.model.Order;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ProductRepository productRepository;

    public Order mapCreateOrderDtoToOrderModel(CreateOrderDto createOrderDto) {

        final List<Product> orderProducts = productRepository.findAllById(createOrderDto.getOrderItems());

        return Order.builder()
                .address(createOrderDto.getAddress())
                .orderSubmissionId(generateSubmissionCode())
                .customerMobile(createOrderDto.getMobileNumber())
                .orderItems(orderProducts).build();
    }

    private String generateSubmissionCode() {

        return String.valueOf(System.currentTimeMillis());
    }
}
