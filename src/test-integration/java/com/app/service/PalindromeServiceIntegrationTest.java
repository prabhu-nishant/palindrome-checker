package com.app.service;

import com.app.PalindromeApplication;
import com.app.model.PalindromeDetails;
import com.app.repository.PalindromeDetailsRepository;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PalindromeApplication.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PalindromeServiceIntegrationTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @BeforeAll
    void setUp() throws InterruptedException {
        palindromeDetailsRepository.save(new PalindromeDetails("tat", true));
        palindromeDetailsRepository.save(new PalindromeDetails("brb", true));
        palindromeDetailsRepository.save(new PalindromeDetails("ctl", false));
        Thread.sleep(10000);
    }

    @Test
    void checkIfValueIsPalindrome_WithCacheHit_AndStringIsPalindrome() {
        Optional<PalindromeDetails> result = ofNullable(cacheManager.getCache("palindromeDetailsCache")).map(c -> c.get("brb", PalindromeDetails.class));
        assertEquals(TestDataHelper.getTestStringPalindromeOrNotDetails("brb"), result);
        assertEquals(true, palindromeService.checkIfValueIsPalindrome("brb"));
    }

    @Test
    void checkIfValueIsPalindrome_WithCacheMiss_AndStringIsNotPalindrome() throws InterruptedException {
        assertEquals(false, palindromeService.checkIfValueIsPalindrome("ctrl"));
        Thread.sleep(10000);
        Optional<PalindromeDetails> result = ofNullable(cacheManager.getCache("palindromeDetailsCache")).map(c -> c.get("ctrl", PalindromeDetails.class));
        assertEquals(TestDataHelper.getTestStringPalindromeOrNotDetails("ctrl"), result);
    }

}