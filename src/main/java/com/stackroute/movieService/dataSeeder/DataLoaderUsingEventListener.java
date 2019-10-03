package com.stackroute.movieService.dataSeeder;


import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieService.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderUsingEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger= LoggerFactory.getLogger(DataLoaderImplCmdLine.class);
    private MovieService movieService;
    private Movie movie=new Movie();

    public DataLoaderUsingEventListener(MovieService movieService){
        this.movieService=movieService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movie.setMovieId(2);
        movie.setMovieName("deepak");
        movie.setReleaseDate("23/10/1996");
        try {
            movieService.saveMovie(movie);
        } catch (MovieAlreadyExistsException e) {
            e.printStackTrace();
        }

    }
}
