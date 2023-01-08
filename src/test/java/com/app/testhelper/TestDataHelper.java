package com.app.testhelper;

import com.app.entity.PalindromeDetails;
import com.app.entity.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class TestDataHelper {

    public static final String VALID_TEST_STRING = "Test";

    public static final String EMPTY_STRING = "";

    public static final String NULL_STRING = null;

    public static final String ALPHA_NUMERIC_STRING = "madam123";

    public static final String NUMERIC_STRING = "12345";

    public static final String PALINDROME_STRING = "madam";

    public static final String NOT_A_PALINDROME_STRING = "madama";

    public static final boolean IS_PALINDROME_TRUE = true;

    public static final boolean IS_PALINDROME_FALSE = false;


    public static String getTestUserDetails() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("abc");
        userDetails.setValue("madam");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static String getExpectedResultUserDetails() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("abc");
        userDetails.setValue("madam");
        userDetails.setPalindrome(true);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static Optional<PalindromeDetails> getTestStringPalindromeDetails()  {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_TRUE);
        return Optional.of(palindromeDetails);
    }

    public static Optional<PalindromeDetails> getTestStringNotPalindromeDetails()  {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(NOT_A_PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_FALSE);
        return Optional.of(palindromeDetails);
    }

}
