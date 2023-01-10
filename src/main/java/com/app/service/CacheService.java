package com.app.service;

import com.app.model.PalindromeDetails;

import java.util.List;
import java.util.Optional;

public interface CacheService<V, K> {

    PalindromeDetails saveValueToCache(V value, K key);

    Optional<V> getValueFromCache(K key);

    List<V> getAllCacheValues();

}
