package com.stackroute.movieService.exceptions;

public class MovieNotFoundException extends Exception {
    private String message;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}


