package com.rinha.rinhabackend.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlingMethodArgumentNotValidException() {
        return new ResponseEntity<>("", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handlingInvalidInputException() {
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }
}
