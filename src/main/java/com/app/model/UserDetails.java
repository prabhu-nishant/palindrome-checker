package com.app.model;

import lombok.Data;

/**
 * @author prabh
 * @implNote This is a request which is received as a request parameter for the api.
 * The getters and setters for the variables are auto handled with @Data annotation.
 */
@Data
public class UserDetails {

    private String username;

    private String value;

    private boolean isPalindrome;

}
