package com.app.validator;

import com.app.exception.InvalidStringException;
import com.app.util.ErrorCodes;
import com.app.util.Utils;
import org.springframework.util.StringUtils;

/**
 * @author prabh
 * @implNote EmptyStringValidator checks if the given string is null or empty.
 */
public class EmptyStringValidator extends AbstractValidator<String> {

    @Override
    public void validate(String value) throws Exception {

        if (!StringUtils.hasLength(value)) {
            throw new InvalidStringException(ErrorCodes.EMPTY_STRING_ERROR_MESSAGE.toString());
        }

        if (getNextValidator() != null) {
            getNextValidator().validate(value);
        }
    }
}
