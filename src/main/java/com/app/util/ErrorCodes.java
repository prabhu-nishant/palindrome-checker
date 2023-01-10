package com.app.util;

/**
 * @author prabh
 * @implNote The ErrorCodes is an Enum of all the error codes the application wants to show to the end user.
 */
public enum ErrorCodes {
    EMPTY_STRING_ERROR_MESSAGE("ERR_0001","Entered value is empty or contains spaces.Please re-enter the correct string!"),
    NUMBERS_STRING_ERROR_MESSAGE("ERR_0002","Entered value contains numbers.Please re-enter the correct string!");

    private final String code;

    private final String message;

    ErrorCodes(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
