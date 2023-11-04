package com.rinha.rinhabackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StringFieldValidator implements ConstraintValidator<StringField, Object> {
    @Override
    public void initialize(StringField constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (!(value instanceof String)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return value == null || value instanceof String;
    }
}
