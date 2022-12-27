package com.example.nadahassanplatform.orders.controller;

import com.example.nadahassanplatform.orders.dto.ShippingDto;
import com.example.nadahassanplatform.orders.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.nadahassanplatform.orders.controller.ShippingController.SHIPPING_ROOT_PATH;

@RestController
@RequestMapping(path = SHIPPING_ROOT_PATH)
@RequiredArgsConstructor
@CrossOrigin
public class ShippingController {

    private final ShippingService shippingService;
    static final String SHIPPING_ROOT_PATH = "/shipping";
    static final String SHIPPING_GOVERNMENTS_ROOT_PATH = "/governments";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShippingDto>> getAllShippings() {
        final List<ShippingDto> shippings = shippingService.getAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }

    @GetMapping(path = SHIPPING_GOVERNMENTS_ROOT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllShippingGovernments() {
        final List<String> governments = shippingService.getAllShippingGovernments();
        return new ResponseEntity<>(governments, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addShipping(@RequestBody final ShippingDto shippingDto) {
        shippingService.addShipping(shippingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
