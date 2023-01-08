package com.app.validator;

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
class NoNumeralValidatorTest {

    private NoNumeralValidator noNumeralValidator;

    @BeforeAll
    void setUp() {
        noNumeralValidator = new NoNumeralValidator();
    }

    @AfterAll
    void tearDown() {
    }

    @Test
    void checkAlphabeticString() throws Exception {
        noNumeralValidator.validate(TestDataHelper.VALID_TEST_STRING);
    }

    @Test
    void checkAlphaNumericString() {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            noNumeralValidator.validate(TestDataHelper.ALPHA_NUMERIC_STRING);
        });

        String expectedMessage = Utils.NUMBERS_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void checkNumericString() {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            noNumeralValidator.validate(TestDataHelper.NUMERIC_STRING);
        });

        String expectedMessage = Utils.NUMBERS_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}