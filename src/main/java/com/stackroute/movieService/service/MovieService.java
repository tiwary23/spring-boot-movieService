package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exceptions.DataBaseNotFoundException;
import com.stackroute.movieService.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieService.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    public List<Movie> getAllMovies() throws DataBaseNotFoundException;

    public Movie updateMovie(Movie movie) throws MovieNotFoundException;

    public Movie deleteMovie(int movieId) throws MovieNotFoundException;

    public Movie getMovieByName(String movieName) throws MovieNotFoundException;

}
