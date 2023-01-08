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
class EmptyStringValidatorTest {

    private EmptyStringValidator emptyStringValidator;

    @BeforeAll
    void setUp() {
        emptyStringValidator = new EmptyStringValidator();
    }

    @AfterAll
    void tearDown() {
    }

    @Test
    void checkValidString() throws Exception {
        emptyStringValidator.validate(TestDataHelper.VALID_TEST_STRING);
    }

    @Test
    void checkEmptyString()  {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            emptyStringValidator.validate(TestDataHelper.EMPTY_STRING);
        });

        String expectedMessage = Utils.EMPTY_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void checkNullString()  {

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            emptyStringValidator.validate(TestDataHelper.NULL_STRING);
        });

        String expectedMessage = Utils.EMPTY_STRING_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}