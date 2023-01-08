package com.app.controller;


import com.app.main.PalindromeApplication;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PalindromeApplication.class)
@AutoConfigureMockMvc
class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkPalindrome() throws Exception {
        String uri = "/api/palindrome";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(TestDataHelper.getTestUserDetails())).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(TestDataHelper.getExpectedResultUserDetails(),content);
    }

}