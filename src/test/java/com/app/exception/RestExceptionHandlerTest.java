package com.app.exception;

import com.app.service.PalindromeService;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class RestExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PalindromeService palindromeService;

    @Test
    void handleHttpRequestMethodNotSupported() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TestDataHelper.URI)
                        .content(TestDataHelper.getTestInvalidUserDetails())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("GET method is not supported. Supported method is POST"));
    }

    @Test
    void handleHttpMediaTypeNotSupported() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(TestDataHelper.URI)
                        .content(TestDataHelper.getTestUserDetails("Johnny", "madam"))
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("text/plain;charset=UTF-8 media type is not supported. Supported media types are application/json, application/*+json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['debugMessage']").value("Content-Type 'text/plain;charset=UTF-8' is not supported"));
    }

    @Test
    void handleMethodArgumentNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(TestDataHelper.URI)
                        .content(TestDataHelper.getTestUserDetailsWithInvalidString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("Validation error"));
    }

    @Test
    void handleHttpMessageNotReadable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(TestDataHelper.URI)
                        .content(TestDataHelper.getTestInvalidUserDetails())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("Malformed JSON request"));
    }

}