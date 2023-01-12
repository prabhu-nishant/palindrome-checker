package com.app.exception.model;

import com.app.validator.ValidString;
import com.app.validator.ValidStringWithNoNumbers;
import lombok.Data;

/**
 * @author prabh
 * @implNote This is a request which is received as a request parameter for the api.
 * The getters and setters for the variables are auto handled with @Data annotation.
 */
@Data
public class UserDetails {

    @ValidString(message = "The username should not be empty or contain whitespaces")
    private String username;

    @ValidString(message = "The value should not be empty or contain whitespaces")
    @ValidStringWithNoNumbers(message = "The value should not contain numbers")
    private String value;

    private boolean isPalindrome;

}
