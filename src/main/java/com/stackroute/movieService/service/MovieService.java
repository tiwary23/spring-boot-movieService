package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exception.MovieAlreadyExistsException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) /*throws MovieAlreadyExistsException*/;

    public List<Movie> getAllMovies();

    public Movie updateMovie(Movie movie);

    public String deleteMovie(int movieId);

    public Movie getMovieByName(String movieName);

}
