package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie= movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public String deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
        return "Deleted";
    }
}
