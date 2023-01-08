package com.app.validator;

public interface IValidator<T> {

    IValidator<T> setNext(IValidator<T> next);
    void validate(T request) throws Exception;

}
