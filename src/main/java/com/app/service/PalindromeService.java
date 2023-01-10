package com.app.service;

/**
 * @author prabh
 * @implNote PalindromeService is an interface used to check if the given string is palindrome or not.
 */
public interface PalindromeService {

    /**
     * @implNote The method simply checks whether the string is palindrome or not.
     *
     * A palindrome is a word, number, phrase, or other sequence of
     * characters which reads the same backward as forward, such as madam or kayak.
     *
     * @param input
     * @return
     */
    boolean checkIfValueIsPalindrome(String input);
}
