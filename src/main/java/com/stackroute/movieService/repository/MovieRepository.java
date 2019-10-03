package com.stackroute.movieService.repository;

import com.stackroute.movieService.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("select m from #{#entityName} m where m.movieName = :movieName")
     public Movie movieByName(@Param("movieName") String movieName);
}
