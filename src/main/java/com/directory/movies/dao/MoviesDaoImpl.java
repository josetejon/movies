package com.directory.movies.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.directory.movies.domain.Movie;

@Component
public class MoviesDaoImpl implements MoviesDao{
	
	private MongoTemplate mongoTemplate;
    
    @Autowired
    public MoviesDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
    public MoviesDaoImpl() {
    	super();
    }
	
    public List<Movie> findMoviesByYear(int year) {
    	Query query = new Query();
    	query.addCriteria(Criteria.where("year").is(year));
    	return mongoTemplate.find(query, Movie.class);
    }

    public List<Movie> findAll() {
    	return mongoTemplate.findAll(Movie.class);
    }
    
    public void save(Movie movie) {

    	Movie a = mongoTemplate.save(movie);
    	
    	System.out.print(a.getTitle() + a.getYear());
    }
	
    
}