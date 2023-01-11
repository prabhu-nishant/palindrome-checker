package com.app.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidStringWithNoNumbersValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStringWithNoNumbers {
    String message() default "String contains numbers";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
