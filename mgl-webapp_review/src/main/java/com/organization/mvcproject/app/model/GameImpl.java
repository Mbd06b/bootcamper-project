package com.organization.mvcproject.app.model;

import java.util.List;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

public class GameImpl implements Game {

	Long id;
	String name;
	String genre;
	Long companyId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public Company getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCompany(Company company) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Review> getReviews() {
		// intentionally unimplemented
		return null;
	}
	@Override
	public void setReviews(List<Review> reviews) {
		// intentionally unimplemented
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
