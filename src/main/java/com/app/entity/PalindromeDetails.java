package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PalindromeDetails {

    @Id
    private String inputString;

    private boolean isPalindrome;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(boolean isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

}
