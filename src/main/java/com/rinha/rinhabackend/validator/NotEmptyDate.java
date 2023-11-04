package com.rinha.rinhabackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotEmptyDateValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyDate {
    String message() default "Date format is wrong";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
