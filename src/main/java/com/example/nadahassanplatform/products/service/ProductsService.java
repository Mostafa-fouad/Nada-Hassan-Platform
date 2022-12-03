package com.example.nadahassanplatform.products.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"products-cache"})
@Service
public class ProductsService {
}
