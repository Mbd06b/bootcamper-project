package com.organization.mvcproject.app.model;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

public class ReviewImpl implements Review {
	
	private Long id; 
	private String body;
	private String author;
	private Integer rating;
	private Long gameId; 
	
	public ReviewImpl() {}
	
    public ReviewImpl(Long id, String body, String author, int rating, long gameId) {
		this.id = id;
		this.author = author;
		this.body = body;
		this.rating = rating; 
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

	@Override
	public String getBody() {
	   return body; 
	}

	@Override
	public void setBody(String body) {
		this.body = body;		
	}

	@Override
	public Game getGame() {
		// intentionally unimplemented
		return null;
	}

	@Override
	public void setGame(Game game) {
		// intentionally unimplemented
	}

	public Long getGameId() {
		return gameId;
	}
	
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
