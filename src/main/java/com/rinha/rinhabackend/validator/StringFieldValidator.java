package com.rinha.rinhabackend.validator;

import com.rinha.rinhabackend.errorHandler.InvalidInputException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class StringFieldValidator implements ConstraintValidator<StringField, String> {
//    @Override
//    public void initialize(StringField constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
////        if (value == null) {
////            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
////        } else if (!(value instanceof String)) {
////            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
////        } else if (value.toString().isBlank()) {
////            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
////        }
//
//        if (!(value instanceof String)) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//
//        return value instanceof String;
//    }


    @Override
    public void initialize(StringField constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (isNumeric(value)) {
            throw new InvalidInputException("Invalid input for nickname or name");
        } else if (value.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return true;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
