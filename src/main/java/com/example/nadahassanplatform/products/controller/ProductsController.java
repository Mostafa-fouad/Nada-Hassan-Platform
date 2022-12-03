package com.example.nadahassanplatform.products.controller;

import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.nadahassanplatform.products.controller.ProductsController.PRODUCTS_ROOT_PATH;

@RestController
@RequestMapping(path = PRODUCTS_ROOT_PATH)
@RequiredArgsConstructor
public class ProductsController {

    static final String PRODUCTS_ROOT_PATH = "/products";
    private static final String GET_PRODUCT_BY_ID_PATH = "/{id}";
    private static final String UPDATE_PRODUCT_DESCRIPTION_PATH = "/description";

    private final ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String checkAppStatus() {

        return "App is up and running...";
    }

    @GetMapping(path = GET_PRODUCT_BY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@PathVariable final UUID id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }
}
