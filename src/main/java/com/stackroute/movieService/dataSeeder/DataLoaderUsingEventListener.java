package com.stackroute.movieService.dataSeeder;


import com.stackroute.movieService.domain.Movie;
import com.stackroute.movieService.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderUsingEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger= LoggerFactory.getLogger(DataLoaderImplCmdLine.class);
    private MovieRepository movieRepository;
    private Movie movie=new Movie();

    public DataLoaderUsingEventListener(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("loading from event listener");
        movie.setMovieId(2);
        movie.setMovieName("deepak");
        movie.setReleaseDate("23/10/1996");
        movieRepository.save(movie);

    }
}
