package com.organization.mvcproject.api.model;

import java.util.List;

public interface Game {

	//modifiers are implicitly public in an interface
	Long getId();
	void setId(Long id);
	String getName();
	void setName(String name);
	String getGenre();
	void setGenre(String genre);
	Company getCompany();
	void setCompany(Company company);
	List<Review> getReviews();
	void setReviews(List<Review> reviews);
	
}
