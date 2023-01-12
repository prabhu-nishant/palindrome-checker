package com.app.validator;

import com.app.testhelper.TestDataHelper;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringValidatorTest {

    @Mock
    private ValidString validString;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private StringValidator stringValidator ;

    @BeforeAll
    void setUp(){
        stringValidator =  new StringValidator();
        stringValidator.initialize(validString);
    }

    @Test
    public void testIsValidString() {
        String input = TestDataHelper.VALID_TEST_STRING;
        boolean result = stringValidator.isValid(input, constraintValidatorContext);
        assertTrue(result);
    }

    @Test
    public void testIsValidString_EmptyString() {

        String input = TestDataHelper.EMPTY_STRING;
        boolean result = stringValidator.isValid(input, constraintValidatorContext);
        assertFalse(result);
    }

    @Test
    public void testIsValidString_NullString() {

        String input = TestDataHelper.NULL_STRING;
        boolean result = stringValidator.isValid(input, constraintValidatorContext);
        assertFalse(result);
    }

    @Test
    public void testIsValidString_StringWithWhiteSpaces() {

        String input = TestDataHelper.STRING_WITH_WHITE_SPACES;
        boolean result = stringValidator.isValid(input, constraintValidatorContext);
        assertFalse(result);
    }


}