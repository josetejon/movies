package com.directory.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.directory.movies.domain.CreateMovieRequest;
import com.directory.movies.domain.Movie;

public interface MoviesController {	
	public void createMovie(CreateMovieRequest request);
	public List<Movie> findMoviesByYear(@RequestParam(value = "year", required = false) String year);
}