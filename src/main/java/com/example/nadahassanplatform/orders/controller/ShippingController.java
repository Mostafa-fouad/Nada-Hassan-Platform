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

    private static final String SHIPPING_GOVERNMENTS_ROOT_PATH = "/governments";
    private final ShippingService shippingService;
    static final String SHIPPING_ROOT_PATH = "/shipping";

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

    @PostMapping
    public ResponseEntity<Void> addShipping(@RequestBody final ShippingDto shippingDto) {
        shippingService.addShipping(shippingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Void> editShippingFees(@RequestBody final ShippingDto shippingDto) {
        shippingService.editShippingFees(shippingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGovernment(@RequestParam final String governmentName) {
        shippingService.deleteGovernment(governmentName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Double> getFeesByGovernment(@RequestParam final String governmentName) {
        return new ResponseEntity<>(shippingService.getFeesByGovernment(governmentName)
                ,HttpStatus.OK);
    }
}
