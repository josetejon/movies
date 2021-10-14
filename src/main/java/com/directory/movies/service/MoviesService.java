package com.directory.movies.service;

import java.util.List;

import com.directory.movies.domain.CreateMovieRequest;
import com.directory.movies.domain.Movie;

public interface MoviesService {

	public List<Movie> findMoviesByYear(String year);
	public void insertNewMovie(CreateMovieRequest m);
}
