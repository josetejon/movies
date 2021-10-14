package com.directory.movies.domain;

public class CreateMovieRequest {
	public CreateMovieRequest(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}
	String title;
	int year;
		
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