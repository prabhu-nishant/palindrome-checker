package com.app.exception;

import com.app.PalindromeApplication;
import com.app.testhelper.TestDataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = PalindromeApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:application-test.properties"})
class RestExceptionHandlerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

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