package com.app.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidString {
    String message() default "String is empty or null";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
