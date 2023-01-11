package com.app.controller;

import com.app.model.UserDetails;
import com.app.service.PalindromeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author prabh
 * @apiNote A PalindromeController serves as the rest endpoint to check the palindrome functionality
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    /**
     * @param userDetails in json format
     * @return userDetails in json format
     * @throws Exception
     * @implNote The method checks whether "value" field supplied in the userDetails json is palindrome or not.
     */
    @ResponseBody
    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public UserDetails checkPalindrome(@Valid @RequestBody UserDetails userDetails) throws Exception {

        boolean isPalindrome = palindromeService.checkIfValueIsPalindrome(userDetails.getValue());
        userDetails.setPalindrome(isPalindrome);
        return userDetails;
    }

}
