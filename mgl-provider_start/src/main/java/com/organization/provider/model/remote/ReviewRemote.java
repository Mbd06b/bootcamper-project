package com.organization.provider.model.remote;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ReviewRemote implements Review {
	
	private Long id;
	private String body;
	private String author;
	private Integer rating;
	
    @JsonBackReference
	private Game game; 
	
    public ReviewRemote() {}
    
    public ReviewRemote(Review review) {
    	BeanUtils.copyProperties(review, this, "game");
    	if(review.getGame() != null) {
    		this.game = GameRemote.convert(review.getGame());
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

    @Override
	public Long getId() {
		return id;
	}

    @Override
	public void setId(Long id) {
		this.id = id;
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
	public String getAuthor() {
		return author;
	}
    
    @Override
	public void setAuthor(String author) {
		this.author = author;
	}

    @Override
	public Integer getRating() {
		return rating;
	}

    @Override
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	@JsonSerialize(as=GameRemote.class)
	public Game getGame() {
		return game != null ? (Game) game: null; 
	}

	@Override
	@JsonDeserialize(as=GameRemote.class)
	public void setGame(Game game) {
		this.game = GameRemote.convert(game); 
	}


}
