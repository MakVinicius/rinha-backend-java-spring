package com.rinha.rinhabackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class NotEmptyDateValidator implements ConstraintValidator<NotEmptyDate, Date> {

    @Override
    public void initialize(NotEmptyDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        // Check if the date is not null and not equal to an empty date
        return date != null && !date.equals(new Date(0));
    }
}
