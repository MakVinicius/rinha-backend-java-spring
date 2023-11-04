package com.rinha.rinhabackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotEmptyDateValidator implements ConstraintValidator<NotEmptyDate, String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public void initialize(NotEmptyDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String dateString, ConstraintValidatorContext context) {
        if (dateString == null || dateString.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);

        try {
            if (!(dateString instanceof String)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            Date parsedDate = dateFormat.parse(dateString);

            return dateString.equals(dateFormat.format(parsedDate));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public boolean isValid(Date date) {
        // Check if the date is not null and not equal to an empty date
        return date != null && !date.equals(new Date(0));
    }
}
