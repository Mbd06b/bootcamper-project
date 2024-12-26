package com.organization.mvcproject.app.model.view;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Review;

public class ReviewView {
	
	private Long id;
	private Long gameId; 
	private String body;
	private String author;
	private Integer rating;
	
    public ReviewView() {}
    
    public ReviewView(Review review) {
    	BeanUtils.copyProperties(review, this);
    }
   
	public static ReviewView convert(Review review) {
    	if(review ==null) {
    		return new ReviewView();
    	}
    	if(review instanceof ReviewView) {
    		return (ReviewView) review;
    	} else {
    		return new ReviewView(review); 
    	}
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}



}
