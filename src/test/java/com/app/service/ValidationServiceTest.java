package com.app.service;

import com.app.exception.InvalidStringException;
import com.app.testhelper.TestDataHelper;
import com.app.utils.Utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidationServiceTest {

    private ValidationService validationService;

    @BeforeAll
    public void setUp(){
        validationService = new ValidationService();
    }

    @Test
    public void checkValidString() throws Exception {

        boolean isValidString = validationService.isValidString(TestDataHelper.VALID_TEST_STRING);
        assertEquals(true,isValidString);

    }

    @Test
    public void checkEmptyString()  {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            validationService.isValidString(TestDataHelper.EMPTY_STRING);
        });

        String expectedMessage = Utils.EMPTY_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void checkNullString()  {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            validationService.isValidString(TestDataHelper.NULL_STRING);
        });

        String expectedMessage = Utils.EMPTY_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void checkNumberString() {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            validationService.isValidString(TestDataHelper.NUMBER_STRING);
        });

        String expectedMessage = Utils.NUMBERS_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @AfterAll
    public void tearDown() {
        validationService = null;
    }
}