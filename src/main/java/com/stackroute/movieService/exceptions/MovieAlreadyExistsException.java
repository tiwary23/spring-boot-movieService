package com.stackroute.movieService.exceptions;

public class MovieAlreadyExistsException extends Exception {
    private String message;

    public MovieAlreadyExistsException(){

    }

    public MovieAlreadyExistsException(String messsage){
        super(messsage);
        this.message=messsage;
    }
}
