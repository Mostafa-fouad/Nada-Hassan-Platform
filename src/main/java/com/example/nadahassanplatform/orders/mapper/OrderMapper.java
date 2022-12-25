package com.example.nadahassanplatform.orders.mapper;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.OrderItemDto;
import com.example.nadahassanplatform.orders.model.Orders;
import com.example.nadahassanplatform.orders.util.OrderProduct;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ProductRepository productRepository;

    public Orders mapCreateOrderDtoToOrderModel(final CreateOrderDto createOrderDto) {

        final Map<UUID, OrderProduct> orderProductsMap = new HashMap<>();

        createOrderDto.getOrderItems().forEach(orderItemDto ->
                orderProductsMap.put(orderItemDto.getProductId(), mapOrderItemDtoToOrderProduct(orderItemDto)));

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

    public OrderProduct mapOrderItemDtoToOrderProduct(final OrderItemDto orderItemDto) {

        final Product product = productRepository.findById(orderItemDto.getProductId())
                .orElseThrow(() ->
                        new NotFoundException(String.format("Product with id %s not found", orderItemDto.getProductId())));

        return OrderProduct.builder()
                .quantity(orderItemDto.getQuantity())
                .product(product).build();
    }

    private String generateSubmissionCode() {

        return String.valueOf(System.currentTimeMillis());
    }
}
