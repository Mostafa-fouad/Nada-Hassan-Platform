package com.example.nadahassanplatform.orders.mapper;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.dto.ProductItemDto;
import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.mapper.ProductMapper;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public OrderDto getOrderDto(final Orders order) {

        final List<ProductItemDto> orderProducts = new ArrayList<>();
        order.getOrderItems().keySet()
                .forEach(productId -> {
                    final ProductDto productDto
                            = productMapper.mapProductModelToProductDto(productRepository.findById(productId).get());
                    orderProducts.add(ProductItemDto.builder()
                            .productDto(productDto)
                            .quantity(order.getOrderItems().get(productId)).build());

                });

        return OrderDto.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .address(order.getAddress())
                .createdDate(order.getCreatedDate())
                .updatedDate(order.getUpdatedDate())
                .orderSubmissionId(order.getOrderSubmissionId())
                .orderTotalAmount(order.getOrderTotalAmount())
                .shippingFees(order.getShippingFees())
                .firstName(order.getFirstName())
                .lastName(order.getLastName())
                .city(order.getCity())
                .government(order.getGovernment())
                .mobileNumber(order.getMobileNumber())
                .orderItems(orderProducts).build();
    }


    public Orders mapCreateOrderDtoToOrderModel(final CreateOrderDto createOrderDto) {

        final Map<UUID, Integer> orderProductsMap = new HashMap<>();

        createOrderDto.getOrderItems().forEach(orderItemDto ->
                orderProductsMap.put(orderItemDto.getProductId(), orderItemDto.getQuantity()));

        //TODO total amount and shipping fees should be calculated and added to the Order model down here
        return Orders.builder()
                .address(createOrderDto.getAddress())
                .city(createOrderDto.getCity())
                .email(createOrderDto.getEmail())
                .firstName(createOrderDto.getFirstName())
                .lastName(createOrderDto.getLastName())
                .government(createOrderDto.getGovernment())
                .orderSubmissionId(generateSubmissionCode())
                .mobileNumber(createOrderDto.getMobileNumber())
                .orderTotalAmount(180.5)
                .shippingFees(40.0)
                .orderItems(orderProductsMap).build();
    }

    private String generateSubmissionCode() {

        return String.valueOf(System.currentTimeMillis());
    }
}
