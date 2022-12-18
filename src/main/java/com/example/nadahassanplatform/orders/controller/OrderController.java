package com.example.nadahassanplatform.orders.controller;

import com.example.nadahassanplatform.orders.dto.OrderDto;
import com.example.nadahassanplatform.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.nadahassanplatform.orders.controller.OrderController.ORDERS_ROOT_PATH;

@RestController
@RequestMapping(path = ORDERS_ROOT_PATH)
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    static final String ORDERS_ROOT_PATH = "/orders";

    private final OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        final List<OrderDto> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
