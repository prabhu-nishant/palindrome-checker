package com.app.controller;

import com.app.model.UserDetails;
import com.app.service.PalindromeService;
import com.app.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @apiNote A PalindromeController serves as the rest endpoint to check the palindrome functionality
 * @author prabh
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private ValidationService validationService;

    /**
     * @implNote The method checks whether "value" field supplied in the userDetails json is palindrome or not.
     * @param userDetails in json format
     * @return userDetails in json format
     * @throws Exception
     *
     */
    @ResponseBody
    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public UserDetails checkPalindrome(@RequestBody UserDetails userDetails) throws Exception {

        validationService.isValidString(userDetails.getValue());
        boolean isPalindrome = palindromeService.checkIfValueIsPalindrome(userDetails.getValue());
        userDetails.setPalindrome(isPalindrome);
        return userDetails;
    }

}
