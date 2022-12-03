package com.example.nadahassanplatform.caching.endpoint;

import java.util.Map;

public interface CacheEndpoint {
  void invalidateAllCache();

  Map<String, Object> displayAllCache();
}
