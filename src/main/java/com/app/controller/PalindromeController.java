package com.app.controller;

import com.app.entities.UserDetails;
import com.app.service.PalindromeService;
import com.app.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private ValidationService validationService;

    @ResponseBody
    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public UserDetails checkPalindrome(@RequestBody UserDetails userDetails){

        try {
            validationService.isValidString(userDetails.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDetails;
    }
}
