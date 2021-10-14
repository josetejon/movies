package com.directory.movies.domain;

import java.util.List;

public class ErrorResponse 
{
	
    private String message;
 
    
    private List<String> details; 
 
    public ErrorResponse(String message, List<String> details) {
        super();
        this.setMessage(message);
        this.setDetails(details);
    }
 
    public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}