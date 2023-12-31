package com.rinha.rinhabackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringFieldValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringField {
    String message() default "Field must be a string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
