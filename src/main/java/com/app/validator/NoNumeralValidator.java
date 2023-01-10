package com.app.validator;

import com.app.exception.InvalidStringException;
import com.app.util.ErrorCodes;
import com.app.util.Utils;

public class NoNumeralValidator extends AbstractValidator<String> {

    @Override
    public void validate(String value) throws Exception {

        if (Utils.doesStringContainNumbers(value)) {
            throw new InvalidStringException(ErrorCodes.NUMBERS_STRING_ERROR_MESSAGE.toString());
        }

        if (getNextValidator() != null) {
            getNextValidator().validate(value);
        }
    }
}
