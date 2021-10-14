package com.directory.movies.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.directory.movies.dao.MoviesDaoImpl;
import com.directory.movies.domain.CreateMovieRequest;
import com.directory.movies.domain.Movie;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MoviesServiceImplTest {
	
	@Mock
	private MoviesDaoImpl moviesDaoImpl;
	
	@InjectMocks
	private MoviesServiceImpl moviesServiceImpl;
	
	private CreateMovieRequest request = new CreateMovieRequest("Balto", 1993);
	
	private List<Movie> movies;
	
	private Movie m = new Movie("Balto", 1993);
	
	private static final String STAR_TREK = "Star Trek";
	
    @Before
	public void setUp() {
    	movies = generateStarTrekMovies(30);
	}
	
    /**
     * get movies created the same year
     */
	@Test
	public void getMoviesByYearWithExistingYear(){
		List<Movie> ms = new ArrayList<>();
		ms.add(m);
		when(moviesServiceImpl.moviesDaoImpl.findMoviesByYear(1979)).thenReturn(ms);
		List<Movie> foundMovies = moviesServiceImpl.findMoviesByYear("1979");
		Assert.assertEquals(foundMovies.size(), 1);
	}
	
	
	/**
	 * Insert a movie, return an exception is there is any issue
	 */
	@Test
	public void insertNewMovie(){
		moviesServiceImpl.insertNewMovie(request);

	}
	
	/**
	 * Return the 30 movies
	 */
	
	@Test
	public void getAllMovies(){

		when(moviesServiceImpl.moviesDaoImpl.findAll()).thenReturn(movies);
		List<Movie> foundMovies = moviesServiceImpl.findMoviesByYear(null);
		Assert.assertTrue(foundMovies.size() == 30);
	}
	
	/**
	 * Return the 30 movies
	 */
	
	@Test(expected = IllegalArgumentException.class)
	public void findUsing_NoNUmberString(){
		List<Movie> foundMovies = moviesServiceImpl.findMoviesByYear("AA");
		Assert.assertTrue(foundMovies.size() == 30);
	}
	
	private List<Movie> generateStarTrekMovies(int versions){
		List<Movie> movies = new ArrayList<>();
		for(int i = 1; i<=versions; i++) {
			movies.add(new Movie(STAR_TREK + "" + i, 1978 + i));
		}
		return movies;
	}

}
