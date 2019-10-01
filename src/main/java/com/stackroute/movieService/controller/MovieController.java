package com.stackroute.movieService.controller;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
           responseEntity=new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
        }catch(Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId){
        ResponseEntity responseEntity;
        try{
            movieService.deleteMovie(movieId);
            responseEntity=new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
}
