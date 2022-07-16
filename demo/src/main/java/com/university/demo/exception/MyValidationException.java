package com.university.demo.exception;

import java.util.List;

public class MyValidationException extends RuntimeException {
    public final List<String> errors;

    public MyValidationException(List<String> errors) {
        this.errors = errors;
    }

}
