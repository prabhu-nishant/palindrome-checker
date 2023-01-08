package com.app.service;

import com.app.validator.EmptyStringValidator;
import com.app.validator.IValidator;
import com.app.validator.NoNumeralValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidString(String value) throws Exception {

        IValidator validator = new EmptyStringValidator();
        validator.setNext(new NoNumeralValidator());
        validator.validate(value);
        return true;

    }
}
