package com.app.service;

import com.app.entity.PalindromeDetails;
import com.app.repository.PalindromeDetailsRepository;
import com.app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    private PalindromeDetailsRepository palindromeStringRepository;

    @Override
    public boolean checkIfValueIsPalindrome(String value) {

        Optional<PalindromeDetails> cachedValue = checkIfStringExistsInCacheAndGetValue(value);
        if (cachedValue.isPresent()) {
            return cachedValue.get().isPalindrome();
        }
        boolean isPalindrome = Utils.isStringPalindrome(value);
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(value);
        palindromeDetails.setPalindrome(isPalindrome);
        saveValuesToCache(palindromeDetails, value);
        return isPalindrome;
    }

    @CachePut(value = "palindromeDetails", key = "#value")
    @Async
    private void saveValuesToCache(PalindromeDetails palindromeDetails, String value) {
        palindromeStringRepository.saveAndFlush(palindromeDetails);
    }

    private Optional<PalindromeDetails> checkIfStringExistsInCacheAndGetValue(String value) {
        return palindromeStringRepository.findById(value);
    }


}
