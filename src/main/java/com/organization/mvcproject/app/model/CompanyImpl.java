package com.organization.mvcproject.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.app.api.model.Company;
import com.organization.mvcproject.app.api.model.Game;

@Component
public class CompanyImpl implements Company {

	private Long id;
	private String name;
	private List<Game> gamesMade = new ArrayList<>();

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

	public List<Game> getGamesMade() {
		return gamesMade;
	}

	public void setGamesMade(List<Game> gamesMade) {
		this.gamesMade = gamesMade;
	}
}