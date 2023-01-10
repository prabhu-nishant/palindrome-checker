package com.app.service;

import com.app.model.PalindromeDetails;
import com.app.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    private CacheService<PalindromeDetails, String> palindromeCacheService;

    @Override
    public boolean checkIfValueIsPalindrome(String input) {

        String inputStr = input.toLowerCase();
        Optional<PalindromeDetails> cachedValue = palindromeCacheService.getValueFromCache(inputStr);
        if (cachedValue.isPresent()) {
            return cachedValue.get().isPalindrome();
        }
        boolean isPalindrome = Utils.isStringPalindrome(inputStr);
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(inputStr);
        palindromeDetails.setPalindrome(isPalindrome);
        palindromeCacheService.saveValueToCache(palindromeDetails, inputStr);
        return isPalindrome;
    }
}
