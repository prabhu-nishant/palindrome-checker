package com.app.validator;

import com.app.util.Utils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidStringWithNoNumbersValidator implements ConstraintValidator<ValidStringWithNoNumbers, String> {
    @Override
    public void initialize(ValidStringWithNoNumbers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (Utils.doesStringContainNumbers(value)) {
            isValid = false;
        }

        return isValid;
    }
}
