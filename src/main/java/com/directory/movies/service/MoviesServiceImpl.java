package com.directory.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.directory.movies.dao.MoviesDaoImpl;
import com.directory.movies.domain.CreateMovieRequest;
import com.directory.movies.domain.Movie;

@Service
public class MoviesServiceImpl implements MoviesService{

	@Autowired
	MoviesDaoImpl moviesDaoImpl;
	
	private static final String FIRST_MOVIE= "The first movie was created in 1895.";
	private static final String VALID_TITLE = "The title is not a valid title.";
	private static final String YEAR_MUST_BE_NUMBER_OR_NULL = "The year must be a number greater than 1895 or empty";
	private static final String EMPTY = "";
	private static final int FIRST_MOVIE_YEAR = 1895;

	/**
	 * Return all the movies made an specific year
	 */
	public List<Movie> findMoviesByYear(String year) {
		
		if(year == null || year.equals(EMPTY)) {
			return moviesDaoImpl.findAll(); 
		}else if(isNumericAndValidYear(year)) {
			int yearInt= Integer.valueOf(year);
			List<Movie> movies = moviesDaoImpl.findMoviesByYear(yearInt);
			return movies;
		}else {
			throw new IllegalArgumentException(YEAR_MUST_BE_NUMBER_OR_NULL);
		}
		
	}

	/**
	 * Create a new entry
	 * @return 
	 */
	public void insertNewMovie(CreateMovieRequest m) {
		if (isValidMovie(m)) {
			Movie movie = new Movie(m.getTitle(), m.getYear());
		    moviesDaoImpl.save(movie);
		}
	}
	
	/**
	 * check if a string is a valid number or not. Only null and numbers greater than 1895 are accepted, otherwise, it will throw an exception
	 * @param year
	 * @return
	 */
	private boolean isNumericAndValidYear(String year) {
	    try {
	        Integer.valueOf(year);
	    } catch (NumberFormatException nfe) {
	    	throw new IllegalArgumentException(YEAR_MUST_BE_NUMBER_OR_NULL);
	    }
	    if (!isValidYear( Integer.valueOf(year))){
			throw new IllegalArgumentException(YEAR_MUST_BE_NUMBER_OR_NULL);
		}
	    return true;
	}
	
	/**
	 * return if is a valid year. First movie was done in 1985 by the lumiere brothers.
	 * @param year
	 * @return
	 */
	private boolean isValidYear(int year) {
		return year >= FIRST_MOVIE_YEAR;
	}
	
	
	private boolean isValidMovie (CreateMovieRequest m) {
		
		boolean output = true;
		if (m.getTitle().length() == 0) {
			throw new IllegalArgumentException(VALID_TITLE);
		}else if (!isValidYear(m.getYear())){
			throw new IllegalArgumentException(FIRST_MOVIE);
		}
		
		return output;
	}

}
