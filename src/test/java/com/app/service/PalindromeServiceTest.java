package com.app.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PalindromeServiceTest {

    private PalindromeService palindromeService;

    @BeforeAll
    void setUp() {
        palindromeService = new PalindromeServiceImpl();
    }

    @Test
    void checkIfValueIsPalindrome() {
        palindromeService.checkIfValueIsPalindrome("");

    }

    @AfterAll
    void tearDown() {
        palindromeService = null;
    }

}