package com.stackroute.movieService.dataSeeder;

import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderImplCmdLine implements CommandLineRunner {

    private final Logger logger= LoggerFactory.getLogger(DataLoaderImplCmdLine.class);
    private MovieService movieService;
    private Movie movie=new Movie();

    public DataLoaderImplCmdLine(MovieService movieService){
        this.movieService=movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Data.....");
        movie.setMovieId(1);
        movie.setMovieName("poorvi");
        movie.setReleaseDate("23/05/1997");
        movieService.saveMovie(movie);

    }
}
