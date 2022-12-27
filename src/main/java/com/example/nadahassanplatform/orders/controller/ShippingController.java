package com.example.nadahassanplatform.orders.controller;

import com.example.nadahassanplatform.orders.dto.ShippingDto;
import com.example.nadahassanplatform.orders.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.nadahassanplatform.orders.controller.ShippingController.SHIPPING_ROOT_PATH;

@RestController
@RequestMapping(path = SHIPPING_ROOT_PATH)
@RequiredArgsConstructor
@CrossOrigin
public class ShippingController {

    private final ShippingService shippingService;
    static final String SHIPPING_ROOT_PATH = "/shipping";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShippingDto>> getAllShippings() {
        final List<ShippingDto> shippings = shippingService.getAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }
}
