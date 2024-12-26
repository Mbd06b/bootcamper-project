package com.organization.provider.model.remote;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;

public class CompanyRemote implements Company {
	
	private Long id;
	private String name;
	
    public CompanyRemote() {}

	public CompanyRemote(Company company) {
		BeanUtils.copyProperties(company, this);
	}
    
	public static CompanyRemote convert(Company company) {
    	if(company ==null) {
    		return new CompanyRemote();
    	}
    	if(company instanceof CompanyRemote) {
    		return (CompanyRemote) company;
    	} else {
    		return new CompanyRemote(company); 
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Game> getGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGames(List<Game> games) {
		// TODO Auto-generated method stub
		
	}


	
}