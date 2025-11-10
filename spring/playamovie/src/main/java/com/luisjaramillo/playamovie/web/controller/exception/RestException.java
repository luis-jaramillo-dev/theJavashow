package com.luisjaramillo.playamovie.web.controller.exception;

import com.luisjaramillo.playamovie.domain.exception.MovieAlreadyExist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestException {
    @ExceptionHandler
    public ResponseEntity<Error> handleException(MovieAlreadyExist ex) {
        Error error = new Error("movie-already-exist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleError(Exception ex) {
        Error error = new Error("unknow-error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
