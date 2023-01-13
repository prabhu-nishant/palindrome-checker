package com.app.service;

import com.app.PalindromeApplication;
import com.app.model.PalindromeDetails;
import com.app.repository.PalindromeDetailsRepository;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PalindromeApplication.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
class PalindromeCacheServiceIntegrationTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CacheService<PalindromeDetails, String> palindromeCacheService;

    @Autowired
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @Test
    void saveValueToCache() {
        palindromeCacheService.saveValueToCache(TestDataHelper.getPalindromeCacheValue("aba"), "aba");
        assertEquals(Optional.of(TestDataHelper.getPalindromeCacheValue("aba")), palindromeCacheService.getValueFromCache("aba"));
        Optional<PalindromeDetails> result = ofNullable(cacheManager.getCache("palindromeDetailsCache")).map(c -> c.get("aba", PalindromeDetails.class));
        assertEquals(TestDataHelper.getTestStringPalindromeOrNotDetails("aba"), result);
    }

    @Test
    void getValueFromCache() {
        assertEquals(Optional.of(TestDataHelper.getPalindromeCacheValue("aba")), palindromeCacheService.getValueFromCache("aba"));
        Optional<PalindromeDetails> result = ofNullable(cacheManager.getCache("palindromeDetailsCache")).map(c -> c.get("aba", PalindromeDetails.class));
        assertEquals(TestDataHelper.getTestStringPalindromeOrNotDetails("aba"), result);
    }

    @Test
    void getValueFromCache_ValueNotFound() {
        assertTrue(palindromeCacheService.getValueFromCache("John").isEmpty());
        Optional<PalindromeDetails> result = ofNullable(cacheManager.getCache("palindromeDetailsCache")).map(c -> c.get("John", PalindromeDetails.class));
        assertTrue(result.isEmpty());
    }

    @Test
    void getAllCacheValues() {
        List<PalindromeDetails> result = palindromeCacheService.getAllCacheValues();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}