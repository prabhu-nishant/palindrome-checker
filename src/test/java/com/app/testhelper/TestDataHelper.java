package com.app.testhelper;

import com.app.entities.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataHelper {

    public static final String VALID_TEST_STRING = "Test";

    public static final String EMPTY_STRING = "";

    public static final String NULL_STRING = null;

    public static final String ALPHA_NUMERIC_STRING = "madam123";

    public static final String NUMERIC_STRING = "12345";


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
        userDetails.setIsValuePalindrome(true);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }

}
