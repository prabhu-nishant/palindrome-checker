package com.app.service;

import com.app.model.PalindromeDetails;

import java.util.List;
import java.util.Optional;

/**
 * @author prabh
 * @implNote This is a generic interface used to perform cache operations.
 * @param <V> Value to be stored in the cache.
 * @param <K> Key against which the value would be stored.
 */
public interface CacheService<V, K> {

    /**
     * @implNote This method saves the value to the cache.
     * @param value
     * @param key
     * @return
     */
    PalindromeDetails saveValueToCache(V value, K key);

    /**
     * @implNote This method gets the value from the cache.
     * @param key
     * @return
     */
    Optional<V> getValueFromCache(K key);

    /**
     * @implNote The method returns all the values from the cache.
     * @return
     */
    List<V> getAllCacheValues();

}
