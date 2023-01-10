package com.app.exception;

import com.app.main.PalindromeApplication;
import com.app.testhelper.TestDataHelper;
import com.app.util.ErrorCodes;
import com.app.util.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = PalindromeApplication.class)
@AutoConfigureMockMvc
class RestExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void handleHttpMediaTypeNotSupported() throws Exception {
        String uri = "/api/palindrome";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .content(TestDataHelper.getTestUserDetails())
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("text/plain;charset=UTF-8 media type is not supported. Supported media types are application/json, application/*+json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['debugMessage']").value("Content-Type 'text/plain;charset=UTF-8' is not supported"));
    }

    @Test
    void handleHttpMessageNotReadable() throws Exception {
        String uri = "/api/palindrome";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .content(TestDataHelper.getTestInvalidUserDetails())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value("Malformed JSON request"));
    }

    @Test
    void handleInvalidString() throws Exception {
        String uri = "/api/palindrome";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .content(TestDataHelper.getTestUserDetailsWithInvalidString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$['apierror']['message']").value(ErrorCodes.EMPTY_STRING_ERROR_MESSAGE.toString()));
        ;
    }
}