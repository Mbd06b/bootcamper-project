package com.organization.provider.model.remote;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Review;

public class ReviewRemote {
	
	private Long id;
	private Long gameId;
	private String body;
	private String author;
	private Integer rating;
	
    public ReviewRemote() {}
    
    public ReviewRemote(Review review) {
    	BeanUtils.copyProperties(review, this);
    	if(review.getGame() != null && review.getGame().getId() != null) {
    		this.gameId = review.getGame().getId();
    	}
    }
    
    public static ReviewRemote convert(Review review) {
    	if(review ==null) {
    		return new ReviewRemote();
    	}
    	if(review instanceof ReviewRemote) {
    		return (ReviewRemote) review;
    	} else {
    		return new ReviewRemote(review); 
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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


}
