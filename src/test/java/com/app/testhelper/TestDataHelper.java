package com.app.testhelper;

import com.app.entities.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataHelper {

    public static String VALID_TEST_STRING = "Test";

    public static String EMPTY_STRING = "";

    public static String NULL_STRING = null;

    public static String NUMBER_STRING = "madam123";


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
