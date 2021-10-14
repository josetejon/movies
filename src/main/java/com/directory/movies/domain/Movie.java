package com.directory.movies.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movie")
public class Movie {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
    private String title;
	
	private int year;
	
	@PersistenceConstructor
	public Movie(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}