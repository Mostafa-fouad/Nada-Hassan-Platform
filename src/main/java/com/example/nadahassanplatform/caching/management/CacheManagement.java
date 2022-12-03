package com.example.nadahassanplatform.caching.management;

import java.util.Map;

public interface CacheManagement {

  Map<String, Object> displayAllCache();

  void invalidateAllCache();
}
