package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie);

    public List<Movie> getAllMovies();

    public Movie updateMovie(Movie movie);

    public String deleteMovie(int movieId);

}
