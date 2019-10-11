package com.stackroute.movieService.dataSeeder;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderImplCmdLine implements CommandLineRunner {

    private final Logger logger= LoggerFactory.getLogger(DataLoaderImplCmdLine.class);
    private MovieRepository movieRepository;
    private Movie movie=new Movie();

    public DataLoaderImplCmdLine(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Data.....");
        movie.setMovieId(1);
        movie.setMovieName("poorvi");
        movie.setReleaseDate("23/05/1997");
        movieRepository.save(movie);

    }
}
