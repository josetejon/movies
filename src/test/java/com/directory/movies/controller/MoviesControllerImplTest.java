package com.directory.movies.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.directory.movies.service.MoviesServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MoviesControllerImpl.class)

public class MoviesControllerImplTest {
	
	@MockBean
	private MoviesServiceImpl moviesServiceImpl;
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
     * insert correct movie
     * @throws Exception
     */
    @Test
    public void insertMovie() throws Exception  {
        
    	String body = "{\n" + 
    			"\"title\":\"The godfather 3\",\n" + 
    			"\"year\":1991\n" + 
    			"}";
             mockMvc.perform(post("/createMovie")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    /**
     * Get all the movies
     * @throws Exception
     */
    @Test
    public void getAllMovies() throws Exception  {
        
             mockMvc.perform(get("/findMovies")
            		 .accept(MediaType.APPLICATION_JSON))
		      		 .andExpect(status().isOk());
    }
    
    /**
     * Get movies by year
     * @throws Exception
     */
    @Test
    public void getMoviesByYear() throws Exception  {
        
             mockMvc.perform(get("/findMovies?year=1989")
            		 .accept(MediaType.APPLICATION_JSON))
		      		 .andExpect(status().isOk());
    }
    

}
