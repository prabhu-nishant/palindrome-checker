package com.app.validator;

import com.app.exception.InvalidStringException;
import com.app.util.Utils;
import org.springframework.util.StringUtils;

public class EmptyStringValidator extends AbstractValidator<String> {

    @Override
    public void validate(String value) throws Exception {

        if (!StringUtils.hasLength(value)) {
            throw new InvalidStringException(Utils.EMPTY_STRING_ERROR_MESSAGE);
        }

        if (getNextValidator() != null) {
            getNextValidator().validate(value);
        }
    }
}
