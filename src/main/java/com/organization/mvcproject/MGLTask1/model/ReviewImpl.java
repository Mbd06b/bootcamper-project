package com.organization.mvcproject.MGLTask1.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.organization.mvcproject.api.model.Review;


public class ReviewImpl implements Review{
	
	private String reviewBody;
	private String author;
	private Integer rating;

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
	public String getReviewBody() {
		return reviewBody;
	}

	@Override
	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

}
