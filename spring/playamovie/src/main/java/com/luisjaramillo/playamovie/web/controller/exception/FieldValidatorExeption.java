package com.luisjaramillo.playamovie.web.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FieldValidatorExeption {
    @ExceptionHandler
    public String handleValidationException(Exception e) {
        return e.getMessage();
    }
}
