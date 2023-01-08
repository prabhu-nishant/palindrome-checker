package com.app.validator;

public abstract class AbstractValidator<T> implements IValidator<T> {

    private IValidator<T> nextValidator;

    public IValidator<T> getNextValidator() {
        return nextValidator;
    }

    public void setNextValidator(IValidator<T> nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public IValidator<T> setNext(IValidator<T> next) {
        nextValidator = next ;
        return nextValidator;
    }

    @Override
    public void validate(T request) throws Exception {
        nextValidator.validate(request);
    }
}
