package com.app.testhelper;

import com.app.model.PalindromeDetails;
import com.app.model.UserDetails;
import com.app.util.Utils;
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


    public static String getTestUserDetails(String username, String input) throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(username);
        userDetails.setValue(input);

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

    public static String getExpectedResultUserDetails(String username, String input) throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(username);
        userDetails.setValue(input);
        userDetails.setPalindrome(Utils.isStringPalindrome(userDetails.getValue()));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

    public static Optional<PalindromeDetails> getTestStringPalindromeOrNotDetails(String input) {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(input);
        palindromeDetails.setPalindrome(Utils.isStringPalindrome(input));
        return Optional.of(palindromeDetails);
    }

    public static PalindromeDetails getPalindromeCacheValue(String input) {
        PalindromeDetails palindromeDetails = new PalindromeDetails();
        palindromeDetails.setInputString(input);
        palindromeDetails.setPalindrome(Utils.isStringPalindrome(input));
        return palindromeDetails;
    }

    public static List<PalindromeDetails> getCacheValuesList(String input1, String input2) {

        List<PalindromeDetails> list = new ArrayList<PalindromeDetails>();

        PalindromeDetails palindromeDetails_1 = new PalindromeDetails();
        palindromeDetails_1.setInputString(input1);
        palindromeDetails_1.setPalindrome(Utils.isStringPalindrome(input1));

        PalindromeDetails palindromeDetails_2 = new PalindromeDetails();
        palindromeDetails_2.setInputString(input2);
        palindromeDetails_2.setPalindrome(Utils.isStringPalindrome(input2));

        list.add(palindromeDetails_1);
        list.add(palindromeDetails_2);

        return list;
    }
}
