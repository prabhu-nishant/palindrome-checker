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

    /**
     * This method saves the records to database store asynchronously
     *
     * @param palindromeDetails
     * @param key
     * @return
     */
    @Override
    @CachePut(key = "#key", value = "palindromeDetailsCache", unless = "#result == null")
    public PalindromeDetails saveValueToCache(PalindromeDetails palindromeDetails, String key) {

        CompletableFuture<PalindromeDetails> result = CompletableFuture.supplyAsync(() -> {
            try {
                return palindromeDetailsRepository.save(palindromeDetails);
            } catch (Exception ex) {
                log.error("Exception while persisting data in database " + ex.getLocalizedMessage() + ex.getStackTrace().toString());
                return palindromeDetails;
            }
        });
        result.whenComplete((s, ex) -> {
            log.debug("Data persisted in database store " + s.toString());
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

        return palindromeDetailsRepository.findAll();
    }

}
