package com.example.nadahassanplatform.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.nadahassanplatform.products.controller.ProductsController.PRODUCTS_ROOT_PATH;

@RestController
@RequestMapping(path = PRODUCTS_ROOT_PATH)
@AllArgsConstructor
public class ProductsController {

    static final String PRODUCTS_ROOT_PATH = "/products";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String checkAppStatus() {

        return "App is up and running...";
    }
}
