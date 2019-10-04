package com.stackroute.movieService.service;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exceptions.DataBaseNotFoundException;
import com.stackroute.movieService.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieService.exceptions.MovieNotFoundException;
import com.stackroute.movieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDummyService implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieDummyService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException();
        }
        Movie savedMovie= movieRepository.save(movie);
        System.out.println("this is from Dummy");
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() throws DataBaseNotFoundException {
        if(movieRepository.findAll().isEmpty()){
            throw new DataBaseNotFoundException();
        }
        System.out.println("this is from Dummy");
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException {
        if(!movieRepository.existsById(movie.getMovieId())){
            throw new MovieNotFoundException();
        }
        return movieRepository.save(movie);
    }

    @Override
    public String deleteMovie(int movieId) throws MovieNotFoundException {
        if(!movieRepository.existsById(movieId)){
            throw new MovieNotFoundException();

        }
        movieRepository.deleteById(movieId);
        System.out.println("this is from Dummy");
        return "Deleted";
    }

    @Override
    public Movie getMovieByName(String movieName) throws MovieNotFoundException {
        if(movieRepository.movieByName(movieName)==null){
            throw new MovieNotFoundException();
        }
        System.out.println("this is from Dummy");
        return movieRepository.movieByName(movieName);
    }
}
