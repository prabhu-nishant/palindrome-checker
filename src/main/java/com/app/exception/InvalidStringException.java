package com.app.exception;

/**
 * @author prabh
 * @implNote This is a custom Exception class for invalid strings.
 *
 * */
public class InvalidStringException extends RuntimeException {

    public InvalidStringException(String errorMessage) {
        super(errorMessage);
    }
}
