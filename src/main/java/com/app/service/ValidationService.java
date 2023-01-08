package com.app.service;

import com.app.validator.EmptyStringValidator;
import com.app.validator.IValidator;
import com.app.validator.NoNumeralValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private final IValidator validator;

    public ValidationService() {
        validator = new EmptyStringValidator();
        validator.setNext(new NoNumeralValidator());
    }

    public void isValidString(String value) throws Exception {

        validator.validate(value);

    }
}
