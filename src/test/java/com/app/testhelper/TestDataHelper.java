package com.app.testhelper;

import com.app.entities.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataHelper {

    public static String getTestUserDetails() throws JsonProcessingException {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("abc");
        userDetails.setValue("madam");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDetails);

    }
}
