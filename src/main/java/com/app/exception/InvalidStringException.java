package com.app.exception;

public class InvalidStringException extends RuntimeException {

    public InvalidStringException(String errorMessage) {
        super(errorMessage);
    }
}
