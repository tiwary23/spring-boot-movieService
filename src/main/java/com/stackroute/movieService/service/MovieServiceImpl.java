package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exceptions.DataBaseNotFoundException;
import com.stackroute.movieService.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieService.exceptions.MovieNotFoundException;
import com.stackroute.movieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("service")
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException{
        if(movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException();
        }
        Movie savedMovie= movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() throws DataBaseNotFoundException{
        if(movieRepository.findAll().isEmpty()){
            throw new DataBaseNotFoundException();
        }
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException{
        if(!movieRepository.existsById(movie.getMovieId())){
            throw new MovieNotFoundException();
        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie deleteMovie(int movieId) throws MovieNotFoundException {
        if(!movieRepository.existsById(movieId)){
            throw new MovieNotFoundException();

        }

        Movie deletedMovie=movieRepository.findById(movieId).get();
        movieRepository.deleteById(movieId);
        return deletedMovie;
    }

    @Override
    public Movie getMovieByName(String movieName) throws MovieNotFoundException {
        if(movieRepository.movieByName(movieName)==null){
            throw new MovieNotFoundException();
        }
        return movieRepository.movieByName(movieName);
    }
}
