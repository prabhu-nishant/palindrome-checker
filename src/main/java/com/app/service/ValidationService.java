package com.app.service;

/**
 * @author prabh
 * @implNote ValidationService is an interface used to perform validations.
 */
public interface ValidationService {

    /**
     * @implNote This method checks whether the given string is vallid or not.
     * @param value
     * @throws Exception
     */
    void isValidString(String value) throws Exception;
}
