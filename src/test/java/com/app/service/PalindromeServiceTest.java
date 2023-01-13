package com.app.service;

import com.app.model.PalindromeDetails;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PalindromeServiceTest {

    @InjectMocks
    private PalindromeService palindromeService;

    @Mock
    private CacheService<PalindromeDetails, String> palindromeCacheService;

    @BeforeAll
    void setUp() {
        palindromeService = new PalindromeServiceImpl();
    }

    @Test
    void checkIfValueIsPalindrome_AndStringIsPalindrome() {
        Mockito.when(palindromeCacheService.getValueFromCache(Mockito.anyString())).thenReturn(Optional.empty());
        assertEquals(true, palindromeService.checkIfValueIsPalindrome("madam"));
    }

    @Test
    void checkIfValueIsPalindrome_WithCacheHit_AndStringIsNotPalindrome() {
        Mockito.when(palindromeCacheService.getValueFromCache(Mockito.anyString())).thenReturn(TestDataHelper.getTestStringPalindromeOrNotDetails("abcd"));
        assertEquals(false, palindromeService.checkIfValueIsPalindrome("abcd"));

    }

    @AfterAll
    void tearDown() {
        palindromeService = null;
    }

}