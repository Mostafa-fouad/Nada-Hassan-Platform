package com.example.nadahassanplatform.products.controller;

import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.dto.ProductResponsePageDTO;
import com.example.nadahassanplatform.products.dto.UpdateProductDto;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.products.service.ProductService;
import com.example.nadahassanplatform.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.nadahassanplatform.products.controller.ProductsController.PRODUCTS_ROOT_PATH;

@RestController
@RequestMapping(path = PRODUCTS_ROOT_PATH)
@RequiredArgsConstructor
@CrossOrigin
public class ProductsController {

    private static final String ID_PATH = "/{id}";
    private final ProductService productService;
    static final String PRODUCTS_ROOT_PATH = "/products";

    @GetMapping(path = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@PathVariable final UUID id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping(path= ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addProduct(@RequestBody final CreateProductDto createProductDto)
    {
        productService.addProduct(createProductDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponsePageDTO> getAllProductsPage(final Integer pageNumber,
                                                                     final Integer size,
                                                                     final String orderBy,
                                                                     final String direction) {

        var pageable = PaginationUtils.buildPageable(pageNumber, size, orderBy, direction);

        return new ResponseEntity<>(productService.getAllProductsPage(pageable), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Void> editProduct(@RequestBody final UpdateProductDto updateProductDto) {

        productService.updateProduct(updateProductDto);

        return ResponseEntity.noContent().build();
    }
}
