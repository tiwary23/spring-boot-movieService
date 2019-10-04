package com.stackroute.movieService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(DataBaseNotFoundException.class)
    public ResponseEntity<?> dataBaseNotFoundException(){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<String>("DataBase Not Found", HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> movieAlreadyExistsException(){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<String>("Movie Already Exists", HttpStatus.CONFLICT);
        return responseEntity;

    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> movieNotFoundException(){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<String>("Movie Not Found", HttpStatus.CONFLICT);
        return responseEntity;
    }



}
