package com.app.service;

/**
 * @author prabh
 * @implNote PalindromeService is an interface used to check if the given string is palindrome or not.
 */
public interface PalindromeService {

    /**
     * @param input
     * @return
     * @implNote The method simply checks whether the string is palindrome or not.
     * <p>
     * A palindrome is a word, number, phrase, or other sequence of
     * characters which reads the same backward as forward, such as madam or kayak.
     */
    boolean checkIfValueIsPalindrome(String input);
}
