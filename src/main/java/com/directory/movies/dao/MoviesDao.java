package com.directory.movies.dao;

import java.util.List;

import com.directory.movies.domain.Movie;

public interface MoviesDao{
    
	List<Movie> findAll();
    
    void save(Movie m);
    
    List<Movie> findMoviesByYear(int year);

}