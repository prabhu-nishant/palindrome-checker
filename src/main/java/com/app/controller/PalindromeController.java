package com.app.controller;

import com.app.model.UserDetails;
import com.app.service.PalindromeService;
import com.app.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private ValidationService validationService;

    @ResponseBody
    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public UserDetails checkPalindrome(@RequestBody UserDetails userDetails) throws Exception {

        validationService.isValidString(userDetails.getValue());
        boolean isPalindrome = palindromeService.checkIfValueIsPalindrome(userDetails.getValue());
        userDetails.setPalindrome(isPalindrome);
        return userDetails;
    }

}
