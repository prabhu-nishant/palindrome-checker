package com.app.controller;


import com.app.PalindromeApplication;
import com.app.repository.PalindromeDetailsRepository;
import com.app.service.PalindromeService;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(PalindromeController.class)
class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PalindromeService palindromeService;

    @Test
    void checkPalindrome() throws Exception {
        Mockito.when(palindromeService.checkIfValueIsPalindrome(Mockito.any())).thenReturn(TestDataHelper.IS_PALINDROME_TRUE);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(TestDataHelper.URI).contentType(MediaType.APPLICATION_JSON).content(TestDataHelper.getTestUserDetails())).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(TestDataHelper.getExpectedResultUserDetails(), content);
    }

}