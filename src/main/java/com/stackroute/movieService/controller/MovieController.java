package com.stackroute.movieService.controller;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exceptions.DataBaseNotFoundException;
import com.stackroute.movieService.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieService.exceptions.MovieNotFoundException;
import com.stackroute.movieService.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "movie list",description = "Crud Operations")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping("movie")
    @ApiOperation(value = "Save movie",response = Iterable.class)
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
           responseEntity=new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        }catch (MovieAlreadyExistsException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    @ApiOperation(value = "get all movie",response = Iterable.class)
    public ResponseEntity<?> getAllMovie(){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
        }catch(DataBaseNotFoundException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("movie")
    @ApiOperation(value = "update movie",response = Iterable.class)
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
        }catch (MovieNotFoundException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("movie")
    @ApiOperation(value = "delete movie",response = Iterable.class)
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId){
        ResponseEntity responseEntity;
        try{
            movieService.deleteMovie(movieId);
            responseEntity=new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }catch (MovieNotFoundException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("getmovie")
    @ApiOperation(value = "get movie by name",response = Iterable.class)
    public ResponseEntity<?> getMovieByName(@RequestBody String movieName){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<Movie>(movieService.getMovieByName(movieName),HttpStatus.OK);
        }catch(MovieNotFoundException e){
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


}
