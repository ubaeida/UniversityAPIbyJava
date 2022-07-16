package com.university.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyValidationExceptionHandler {

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity handleValidation(MyValidationException myValidationException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(myValidationException.errors);
    }
}
