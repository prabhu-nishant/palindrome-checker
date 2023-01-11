package com.app.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class StringValidator implements ConstraintValidator<ValidString, String> {
    @Override
    public void initialize(ValidString constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isValid = true;

        if (!StringUtils.hasLength(value) || StringUtils.containsWhitespace(value)) {
            isValid = false;
        }
        return isValid;
    }
}
