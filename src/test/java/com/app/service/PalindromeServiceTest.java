package com.app.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PalindromeServiceTest {

    private PalindromeService palindromeService;

    @BeforeAll
    public void setUp(){
        palindromeService = new PalindromeService();
    }

    @Test
    public void checkIfValueIsPalindrome(){
        palindromeService.checkIfValueIsPalindrome("");

    }

    @AfterAll
    public void tearDown() {
        palindromeService = null;
    }

}