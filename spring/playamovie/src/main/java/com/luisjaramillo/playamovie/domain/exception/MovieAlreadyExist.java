package com.luisjaramillo.playamovie.domain.exception;

public class MovieAlreadyExist extends RuntimeException {
    public MovieAlreadyExist(String movieTitle) {
        super("The movie with title '" + movieTitle + "' already exists.");
    }
}
