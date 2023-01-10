package com.app.service;

import com.app.model.PalindromeDetails;
import com.app.repository.PalindromeDetailsRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Async
    public PalindromeDetails saveValueToCache(PalindromeDetails palindromeDetails, String key) {
        return palindromeDetailsRepository.saveAndFlush(palindromeDetails);
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
        return palindromeDetailsRepository.findAll();
    }

}
