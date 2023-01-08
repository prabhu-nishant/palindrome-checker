package com.app.controller;


import com.app.entities.UserDetails;
import com.app.testhelper.TestDataHelper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PalindromeControllerTest extends AbstractWebContext {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void checkPalindrome() throws Exception {
        String uri = "/api/palindrome";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(TestDataHelper.getTestUserDetails())).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        UserDetails userDetails = super.mapFromJson(content, UserDetails.class);
        assertNotNull(userDetails);
    }

}