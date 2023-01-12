package com.app.service;

import com.app.model.PalindromeDetails;
import com.app.repository.PalindromeDetailsRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author prabh
 * @implNote This class implements the generic cache service to cache PalindromeDetails against the String value.
 */
@Service
@Slf4j
public class PalindromeCacheServiceImpl implements CacheService<PalindromeDetails, String> {

    @Autowired
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @Override
    @CachePut(key = "#key", value = "palindromeDetailsCache", unless = "#result == null")
    public PalindromeDetails saveValueToCache(PalindromeDetails palindromeDetails, String key) {

        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    palindromeDetailsRepository.save(palindromeDetails);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

        return palindromeDetails;
    }

    @Override
    @Cacheable(key = "#key", value = "palindromeDetailsCache", unless = "#result == null")
    public Optional<PalindromeDetails> getValueFromCache(String key) {
        return palindromeDetailsRepository.findById(key);
    }

    @Override
    @PostConstruct
    @Cacheable(value = "palindromeDetailsCache", unless = "#result == null")
    public List<PalindromeDetails> getAllCacheValues() {

        System.out.println("Loading cache");
        return palindromeDetailsRepository.findAll();
    }

}
