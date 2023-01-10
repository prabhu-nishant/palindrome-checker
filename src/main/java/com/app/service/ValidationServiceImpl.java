package com.app.service;

import com.app.validator.EmptyStringValidator;
import com.app.validator.IValidator;
import com.app.validator.NoNumeralValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidationServiceImpl implements ValidationService {

    private final IValidator<String> validator;

    public ValidationServiceImpl() {
        validator = new EmptyStringValidator();
        validator.setNext(new NoNumeralValidator());
    }

    @Override
    public void isValidString(String value) throws Exception {
        validator.validate(value);
    }

}
