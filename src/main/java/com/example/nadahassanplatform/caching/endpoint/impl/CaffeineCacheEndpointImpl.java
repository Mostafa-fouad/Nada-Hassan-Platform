package com.example.nadahassanplatform.caching.endpoint.impl;

import com.example.nadahassanplatform.caching.endpoint.CacheEndpoint;
import com.example.nadahassanplatform.caching.management.CacheManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;

@WebEndpoint(id = "cacheManagement")
@RequiredArgsConstructor
@Component
public class CaffeineCacheEndpointImpl implements CacheEndpoint {

  private final CacheManagement cacheManagement;

  @Override
  @DeleteOperation
  public void invalidateAllCache() {

    cacheManagement.invalidateAllCache();
  }

  @Override
  @ReadOperation
  public Map<String, Object> displayAllCache() {

    return cacheManagement.displayAllCache();
  }
}
