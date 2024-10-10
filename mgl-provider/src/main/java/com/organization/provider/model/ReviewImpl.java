package com.organization.provider.model;

import com.organization.mvcproject.api.model.Review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="REVIEW")
public class ReviewImpl implements Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="BODY")
	private String reviewBody;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="RATING")
	private Integer rating;

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

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}
}
