package com.app.util;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author prabh
 * @implNote This is a utility class to have all common functions.
 */
public class Utils {

    /**
     * @implNote Checks if given string contains numbers. Returns true if it contains numbers.
     * @param value
     * @return
     */
    public static boolean doesStringContainNumbers(String value) {
        Pattern pattern = Pattern.compile(".*\\d.*");

        if (!StringUtils.hasLength(value)) {
            return false;
        }

        return pattern.matcher(value).matches();
    }

    /**
     * @implNote Checks if given string is palindrome or not.
     * A palindrome is a word, number, phrase, or other sequence of
     * characters which reads the same backward as forward, such as madam or kayak.
     * @param value
     * @return
     */
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
