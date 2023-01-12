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
class ValidStringWithNoNumbersValidatorTest {

    @Mock
    private ValidStringWithNoNumbers validStringWithNoNumbers;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private ValidStringWithNoNumbersValidator validStringWithNoNumbersValidator ;

    @BeforeAll
    void setUp(){
        validStringWithNoNumbersValidator  =  new ValidStringWithNoNumbersValidator();
        validStringWithNoNumbersValidator.initialize(validStringWithNoNumbers);
    }

    @Test
    public void testIsValidString() {
        String input = TestDataHelper.VALID_TEST_STRING;
        boolean result = validStringWithNoNumbersValidator.isValid(input, constraintValidatorContext);
        assertTrue(result);
    }


    @Test
    public void testIsValidString_WithNumbers() {
        String input = TestDataHelper.ALPHA_NUMERIC_STRING;
        boolean result = validStringWithNoNumbersValidator.isValid(input, constraintValidatorContext);
        assertFalse(result);
    }

}