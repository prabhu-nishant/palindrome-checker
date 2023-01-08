package com.app.controller;

import com.app.entities.UserDetails;
import com.app.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @ResponseBody
    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public UserDetails checkPalindrome(@RequestBody UserDetails userDetails){

        return userDetails;
    }
}
