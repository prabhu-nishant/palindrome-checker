package com.app.testhelper;

import com.app.model.PalindromeDetails;
import com.app.model.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDataHelper {

    public static final String VALID_TEST_STRING = "Test";

    public static final String EMPTY_STRING = "";

    public static final String NULL_STRING = null;

    public static final String STRING_WITH_WHITE_SPACES = "a a a";

    public static final String ALPHA_NUMERIC_STRING = "madam123";

    public static final String NUMERIC_STRING = "12345";

    public static final String PALINDROME_STRING = "madam";

    public static final String NOT_A_PALINDROME_STRING = "madama";

    public static final boolean IS_PALINDROME_TRUE = true;

    public static final boolean IS_PALINDROME_FALSE = false;

    public static final String URI = "/api/palindrome";


    public static String getTestUserDetails() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("abc");
        userDetails.setValue("madam");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static String getTestInvalidUserDetails() {

        String invalidUserDetails = "{\"username\": \"bob\", \"value\" : \"madam\" , }";
        return invalidUserDetails;

    }

    public static String getTestUserDetailsWithInvalidUsername() {

        String invalidUserDetails = "{\"username\": \"\", \"value\" : \"madam\"  }";
        return invalidUserDetails;

    }

    public static String getTestUserDetailsWithInvalidString() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("Johnny");
        userDetails.setValue("");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static String getExpectedResultUserDetails() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("abc");
        userDetails.setValue("madam");
        userDetails.setPalindrome(true);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static Optional<PalindromeDetails> getTestStringPalindromeDetails() {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_TRUE);
        return Optional.of(palindromeDetails);
    }

    public static Optional<PalindromeDetails> getTestStringNotPalindromeDetails() {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(NOT_A_PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_FALSE);
        return Optional.of(palindromeDetails);
    }

    public static PalindromeDetails getPalindromeCacheValue() {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_TRUE);
        return palindromeDetails;
    }

    public static PalindromeDetails getNotAPalindromeCacheValue() {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(NOT_A_PALINDROME_STRING);
        palindromeDetails.setPalindrome(IS_PALINDROME_FALSE);
        return palindromeDetails;
    }

    public static List<PalindromeDetails> getCacheValuesList() {

        List<PalindromeDetails> list = new ArrayList<PalindromeDetails>();

        PalindromeDetails palindromeDetails_1 = new PalindromeDetails();
        palindromeDetails_1.setInputString(PALINDROME_STRING);
        palindromeDetails_1.setPalindrome(IS_PALINDROME_TRUE);

        PalindromeDetails palindromeDetails_2 = new PalindromeDetails();
        palindromeDetails_2.setInputString(NOT_A_PALINDROME_STRING);
        palindromeDetails_2.setPalindrome(IS_PALINDROME_FALSE);

        list.add(palindromeDetails_1);
        list.add(palindromeDetails_2);

        return list;
    }
}
