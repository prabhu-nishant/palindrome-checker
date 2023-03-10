package com.app.service;

import com.app.repository.PalindromeDetailsRepository;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PalindromeCacheServiceTest {

    @InjectMocks
    private PalindromeCacheServiceImpl palindromeCacheService;

    @Mock
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @Test
    void saveValueToCache() {
        Mockito.when(palindromeDetailsRepository.save(Mockito.any())).thenReturn(TestDataHelper.getPalindromeCacheValue("kayak"));
        assertEquals(TestDataHelper.getPalindromeCacheValue("kayak"), palindromeCacheService.saveValueToCache(TestDataHelper.getPalindromeCacheValue("kayak"), "kayak"));
    }

    @Test
    void getValueFromCache() {
        Mockito.when(palindromeDetailsRepository.findById(Mockito.any())).thenReturn(Optional.of(TestDataHelper.getPalindromeCacheValue("radar")));
        assertEquals(Optional.of(TestDataHelper.getPalindromeCacheValue("radar")), palindromeCacheService.getValueFromCache("radar"));
    }

    @Test
    void getAllCacheValues() {
        Mockito.when(palindromeDetailsRepository.findAll()).thenReturn(TestDataHelper.getCacheValuesList("kayak", "radar"));
        assertEquals(2, palindromeCacheService.getAllCacheValues().size());
        assertEquals(TestDataHelper.getPalindromeCacheValue("kayak"), palindromeCacheService.getAllCacheValues().get(0));
        assertEquals(TestDataHelper.getPalindromeCacheValue("radar"), palindromeCacheService.getAllCacheValues().get(1));

    }
}