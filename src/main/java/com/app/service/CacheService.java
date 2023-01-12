package com.app.service;

import com.app.model.PalindromeDetails;

import java.util.List;
import java.util.Optional;

/**
 * @param <V> Value to be stored in the cache.
 * @param <K> Key against which the value would be stored.
 * @author prabh
 * @implNote This is a generic interface used to perform cache operations.
 */
public interface CacheService<V, K> {

    /**
     * @param value
     * @param key
     * @return
     * @implNote This method saves the value to the cache.
     */
    PalindromeDetails saveValueToCache(V value, K key);

    /**
     * @param key
     * @return
     * @implNote This method gets the value from the cache.
     */
    Optional<V> getValueFromCache(K key);

    /**
     * @return
     * @implNote The method returns all the values from the cache.
     */
    List<V> getAllCacheValues();

}
