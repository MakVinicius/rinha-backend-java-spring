package com.rinha.rinhabackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNumberListValidator.class)
@Target({ElementType.TYPE_USE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNumberList {
    String message() default "Field must be a string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
