package com.app.util;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class Utils {

    public static boolean doesStringContainNumbers(String value) {
        Pattern pattern = Pattern.compile(".*\\d.*");

        if (!StringUtils.hasLength(value)) {
            return false;
        }

        return pattern.matcher(value).matches();
    }

    public static boolean isStringPalindrome(String value) {

        if (!StringUtils.hasLength(value)) {
            return false;
        }
        String tempString = value.replaceAll("\\s+", "").toLowerCase();
        return recursivePalindrome(tempString, 0, tempString.length() - 1);
    }

    private static boolean recursivePalindrome(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(text, forward + 1, backward - 1);
        }
        return true;
    }

}
