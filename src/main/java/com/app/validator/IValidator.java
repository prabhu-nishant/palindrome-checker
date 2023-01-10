package com.app.validator;

/**
 * @author prabh
 * @implNote This is a generic interface used for validations.
 * @param <T>
 */
public interface IValidator<T> {

    /**
     * Sets the next validator in the chain.
     * @param next
     * @return
     */
    IValidator<T> setNext(IValidator<T> next);

    /**
     * Validates the given input
     * @param request
     * @throws Exception
     */
    void validate(T request) throws Exception;

}
