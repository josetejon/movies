package com.directory.movies.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.directory.movies.domain.CreateMovieRequest;
import com.directory.movies.domain.Movie;
import com.directory.movies.service.MoviesServiceImpl;

@RestController
public class MoviesControllerImpl implements MoviesController {
	
	@Autowired
	MoviesServiceImpl movieServiceImpl;
	
	@RequestMapping(value = "/findMovies", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public List<Movie> findMoviesByYear(@RequestParam(value = "year", required = false) String year) {
		
		return movieServiceImpl.findMoviesByYear(year); 
	}

	@RequestMapping(value = "/createMovie", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON })
	public void createMovie(@RequestBody CreateMovieRequest request) {
		
		 movieServiceImpl.insertNewMovie(request);
	}

}
