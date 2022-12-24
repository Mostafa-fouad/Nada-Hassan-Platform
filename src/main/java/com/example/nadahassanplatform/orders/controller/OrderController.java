package com.example.nadahassanplatform.orders.controller;

import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.CreateOrderDto;
import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.service.OrderService;
import com.example.nadahassanplatform.products.dto.CreateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.nadahassanplatform.orders.controller.OrderController.ORDERS_ROOT_PATH;

@RestController
@RequestMapping(path = ORDERS_ROOT_PATH)
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    static final String ORDERS_ROOT_PATH = "/orders";
    private static final String ID_PATH = "/{id}";

    private final OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        final List<OrderDto> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(path = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getOrderByID(@PathVariable final UUID id) {

        return new ResponseEntity<>(orderService.getOrderByID(id), HttpStatus.OK);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addOrder(@RequestBody CreateOrderDto createOrderDto)
    {
        orderService.addOrder(createOrderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateExistingOrder(@RequestBody OrderDto updatedOrder){
        orderService.updateExistingOrder(updatedOrder);
        return ResponseEntity.noContent().build();
    }
}
