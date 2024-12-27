package com.organization.provider.model.persistent;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="REVIEW")
public class ReviewImpl implements Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="BODY")
	private String body;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="RATING")
	private Integer rating;
	    
	@ManyToOne(targetEntity = GameImpl.class)
    @JoinColumn(name = "GAME_ID")
    private Game game;
	
    //spring requires null constructor
    public ReviewImpl() {}
    
    public ReviewImpl(Review review) {
    	BeanUtils.copyProperties(review, this);
    }
    
    public static ReviewImpl convert(Review review) {
    	if(review == null) {
    		return new ReviewImpl();
    	}
    	if(review instanceof ReviewImpl reviewImpl) {
    		return reviewImpl;
    	} else {
    		return new ReviewImpl(review); 
    	}
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

	public void setBody(String reviewBody) {
		this.body = reviewBody;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}
}
