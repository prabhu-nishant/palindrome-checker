package com.app.util;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class Utils {

    public static final String EMPTY_STRING_ERROR_MESSAGE = "Entered value is empty or contains spaces.Please re-enter the correct string!";

    public static final String NUMBERS_STRING_ERROR_MESSAGE = "Entered value contains numbers.Please re-enter the correct string!";

    public static boolean doesStringContainNumbers(String value) {
        Pattern pattern = Pattern.compile(".*\\d.*");

        if (!StringUtils.hasLength(value)) {
            return false;
        }

        return pattern.matcher(value).matches();
    }

}
