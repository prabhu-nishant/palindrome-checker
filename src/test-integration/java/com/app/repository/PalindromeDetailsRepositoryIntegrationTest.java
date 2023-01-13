package com.app.repository;

import com.app.model.PalindromeDetails;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PalindromeDetailsRepositoryIntegrationTest {

    @Autowired
    private PalindromeDetailsRepository palindromeDetailsRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(palindromeDetailsRepository);
    }

    @Test
    void whenSaved_thenFindsByName() {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(TestDataHelper.PALINDROME_STRING);
        palindromeDetails.setPalindrome(TestDataHelper.IS_PALINDROME_TRUE);
        palindromeDetailsRepository.save(palindromeDetails);
        Optional<PalindromeDetails> result = palindromeDetailsRepository.findById(TestDataHelper.PALINDROME_STRING);
        assertFalse(result.isEmpty());
        assertEquals(TestDataHelper.PALINDROME_STRING, (result.get().getInputString()));
        assertEquals(TestDataHelper.IS_PALINDROME_TRUE, result.get().isPalindrome());

    }

    @Test
    void findByIdNotFound() {
        Optional<PalindromeDetails> result = palindromeDetailsRepository.findById(TestDataHelper.VALID_TEST_STRING);
        assertTrue(result.isEmpty());
    }

    @Test
    void findAll() {
        List<PalindromeDetails> result = palindromeDetailsRepository.findAll();
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }
}