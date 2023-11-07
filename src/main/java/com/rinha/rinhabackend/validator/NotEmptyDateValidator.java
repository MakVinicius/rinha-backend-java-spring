package com.rinha.rinhabackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class NotEmptyDateValidator implements ConstraintValidator<NotEmptyDate, LocalDate> {

    @Override
    public void initialize(NotEmptyDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        // Check if the date is not null and not equal to an empty date
        return date != null && !date.equals(LocalDate.of(0, 1, 1));
    }
}
