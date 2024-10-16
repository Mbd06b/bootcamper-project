package com.organization.mvcproject.app.model;

import java.util.List;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;

public class CompanyImpl implements Company {

	private Long id;
	private String name;
	private List<Game> games;

	public CompanyImpl(Long id, String name) {
		this.id = id; 
		this.name = name; 
	}

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

	@Override
	public List<Game> getGames() {
		return games;
	}

	@Override
	public void setGames(List<Game> games) {
		this.games = games;		
	}
}