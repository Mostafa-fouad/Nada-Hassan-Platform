package com.example.nadahassanplatform.products.service.impl;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.products.dto.CreateProductDto;
import com.example.nadahassanplatform.products.dto.ProductDto;
import com.example.nadahassanplatform.products.dto.ProductResponsePageDTO;
import com.example.nadahassanplatform.products.dto.UpdateProductDto;
import com.example.nadahassanplatform.products.mapper.ProductMapper;
import com.example.nadahassanplatform.products.model.Product;
import com.example.nadahassanplatform.products.model.Product.Category;
import com.example.nadahassanplatform.products.repository.ProductRepository;
import com.example.nadahassanplatform.products.service.ProductService;
import com.example.nadahassanplatform.products.util.CategoryCodeMapper;
import com.example.nadahassanplatform.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.example.nadahassanplatform.products.util.CategoryCodeMapper.getAllCategories;

@CacheConfig(cacheNames = {"products-cache"})
@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductDto getProductById(final UUID id) {

        return productMapper.mapProductModelToProductDto(
                productRepository.findById(id).orElseThrow(
                        () -> new NotFoundException (String.format("Product with id %s is not found", id)))
        );
    }

    @Override
    public List<ProductDto> getProductsByCategory(final Integer categoryId) {

        return productRepository.findAllByProductCategory(CategoryCodeMapper.getCategory(categoryId))
                .stream()
                .map(productMapper::mapProductModelToProductDto)
                .toList();
    }

    @Override
    public List<Category> getAllProductsCategories() {
        return getAllCategories();
    }

    @Override
    public void addProduct(final CreateProductDto createProductDto)
    {
        var createdProduct = productMapper.mapCreateProductDtoToProductModel(createProductDto);
        productRepository.save(createdProduct);
    }

    @Override
    public void deleteProductById(final UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponsePageDTO getAllProductsPage(final Pageable pageable) {

        final Page<Product> productPage = productRepository.findAll(pageable);

        final List<ProductDto> productsResponse = productPage.getContent().stream()
                .map(productMapper::mapProductModelToProductDto).toList();

        return ProductResponsePageDTO.builder()
                .page(PaginationUtils.buildPageDTO(modelMapper, productPage))
                .content(productsResponse).build();
    }

    @Override
    public void updateProduct(final UpdateProductDto updateProductDto) {

        final Product product = productRepository.findById(updateProductDto.getId())
                .orElseThrow(() -> new NotFoundException (String.format("Product with id %s not found", updateProductDto.getId())));

        updateProductFields(product, updateProductDto);

        productMapper.mapProductModelToProductDto(productRepository.save(product));
    }

    private void updateProductFields(final Product product, final UpdateProductDto updateProductDto) {

        if (Objects.nonNull(updateProductDto.getCategory()))
            product.setProductCategory(Product.Category.valueOf(updateProductDto.getCategory()));
        if (Objects.nonNull(updateProductDto.getDescription())) product.setDescription(updateProductDto.getDescription());
        if (Objects.nonNull(updateProductDto.getShortDescription())) product.setShortDescription(updateProductDto.getShortDescription());
        if (Objects.nonNull(updateProductDto.getColors())) product.setColors(updateProductDto.getColors());
        if (Objects.nonNull(updateProductDto.getPrimaryImage())) product.setPrimaryImage(updateProductDto.getPrimaryImage());
        if (Objects.nonNull(updateProductDto.getSecondaryImages())) product.setSecondaryImages(updateProductDto.getSecondaryImages());
        if (Objects.nonNull(updateProductDto.getPrice())) product.setPrice(updateProductDto.getPrice());
    }
}
