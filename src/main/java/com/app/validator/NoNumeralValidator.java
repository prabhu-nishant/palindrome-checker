package com.app.validator;

import com.app.exception.InvalidStringException;
import com.app.util.Utils;

public class NoNumeralValidator extends AbstractValidator<String> {

    @Override
    public void validate(String value) throws Exception {

        if(Utils.doesStringContainNumbers(value)){
            throw new InvalidStringException(Utils.NUMBERS_STRING_ERROR_MESSAGE);
        }

        if(getNextValidator()!=null){
            getNextValidator().validate(value);
        }
    }
}
