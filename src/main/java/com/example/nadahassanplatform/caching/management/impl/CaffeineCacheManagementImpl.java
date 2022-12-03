package com.example.nadahassanplatform.caching.management.impl;

import com.example.nadahassanplatform.caching.management.CacheManagement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CaffeineCacheManagementImpl implements CacheManagement {

  private final CaffeineCacheManager cacheManager;

  @Override
  public Map<String, Object> displayAllCache() {

    final Map<String, Object> cacheMap = new HashMap<>();

    cacheManager
        .getCacheNames()
        .forEach(
            cache -> {
              final CaffeineCache caffeineCache =
                  (CaffeineCache) Objects.requireNonNull(cacheManager.getCache(cache));
              cacheMap.putAll(getStoredCache(caffeineCache, cache));
            });

    return cacheMap;
  }

  @Override
  @CacheEvict(value= "products-cache", allEntries = true)
  public void invalidateAllCache() {
    //All products cache will be invalidated once this method has called
  }

  private Map<String, Object> getStoredCache(
      final CaffeineCache caffeineCache, final String cacheName) {

    final Map<String, Object> cacheMap = new HashMap<>();

    cacheMap.put(cacheName, caffeineCache.getNativeCache().asMap());

    return cacheMap;
  }
}
