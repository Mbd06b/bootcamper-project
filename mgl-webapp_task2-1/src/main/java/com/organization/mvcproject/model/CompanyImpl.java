package com.organization.mvcproject.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;

@Component
public class CompanyImpl implements Company{

	private Long id;
	private String name;
	private List<Game> gamesMade;

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
	public List<Game> getGamesMade() {
		return gamesMade;
	}

	@Override
	public void setGamesMade(List<Game> gamesMade) {
		this.gamesMade = gamesMade;
	}
}