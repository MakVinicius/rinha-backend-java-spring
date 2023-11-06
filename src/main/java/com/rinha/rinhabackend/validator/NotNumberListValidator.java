package com.rinha.rinhabackend.validator;

import com.rinha.rinhabackend.errorHandler.InvalidInputException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNumberListValidator implements ConstraintValidator<NotNumberList, String> {
    @Override
    public void initialize(NotNumberList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (string != null && isNumeric(string)) {
            throw new InvalidInputException("Invalid input for nickname or name");
        }

        return true;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
