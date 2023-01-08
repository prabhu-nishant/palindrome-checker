package com.app.service;

import com.app.exception.InvalidStringException;
import com.app.testhelper.TestDataHelper;
import com.app.util.Utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidationServiceTest {

    private ValidationService validationService;

    @BeforeAll
    void setUp() {
        validationService = new ValidationService();
    }

    @Test
    void checkValidString() throws Exception {
        validationService.isValidString(TestDataHelper.VALID_TEST_STRING);
    }

    @Test
    void checkInValidString() {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            validationService.isValidString(TestDataHelper.EMPTY_STRING);
        });

        String expectedMessage = Utils.EMPTY_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @AfterAll
    void tearDown() {
        validationService = null;
    }
}