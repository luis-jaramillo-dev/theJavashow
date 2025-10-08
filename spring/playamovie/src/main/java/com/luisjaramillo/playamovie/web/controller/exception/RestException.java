package com.luisjaramillo.playamovie.web.controller.exception;

import com.luisjaramillo.playamovie.domain.exception.MovieAlreadyExist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException {
    @ExceptionHandler
    public ResponseEntity<Error> handleException(MovieAlreadyExist ex) {
        Error error = new Error("movie-already-exist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
