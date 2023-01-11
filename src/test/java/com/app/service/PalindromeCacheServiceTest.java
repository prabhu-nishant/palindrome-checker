package com.app.service;

import com.app.repository.PalindromeDetailsRepository;
import com.app.testhelper.TestDataHelper;
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
class PalindromeCacheServiceTest {

    @InjectMocks
    private PalindromeCacheServiceImpl palindromeCacheService;

    @Mock
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @BeforeAll
    void setUp() {
        palindromeCacheService = new PalindromeCacheServiceImpl();
    }

    @Test
    void saveValueToCache() {
        Mockito.when(palindromeDetailsRepository.saveAndFlush(Mockito.any())).thenReturn(TestDataHelper.getPalindromeCacheValue());
        assertEquals(TestDataHelper.getPalindromeCacheValue(), palindromeCacheService.saveValueToCache(TestDataHelper.getPalindromeCacheValue(), TestDataHelper.PALINDROME_STRING));
    }

    @Test
    void getValueFromCache() {
        Mockito.when(palindromeDetailsRepository.findById(Mockito.any())).thenReturn(Optional.of(TestDataHelper.getPalindromeCacheValue()));
        assertEquals(Optional.of(TestDataHelper.getPalindromeCacheValue()), palindromeCacheService.getValueFromCache(TestDataHelper.PALINDROME_STRING));
    }

    @Test
    void populateCache() {
        Mockito.when(palindromeDetailsRepository.findAll()).thenReturn(TestDataHelper.getCacheValuesList());
        assertEquals(2, palindromeCacheService.getAllCacheValues().size());
        assertEquals(TestDataHelper.getPalindromeCacheValue(), palindromeCacheService.getAllCacheValues().get(0));
        assertEquals(TestDataHelper.getNotAPalindromeCacheValue(), palindromeCacheService.getAllCacheValues().get(1));

    }
}