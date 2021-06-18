package com.organization.mvcproject.MGLTask1.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Company;

@Component
public class CompanyImpl implements Company{
	
	private Long id;
	private String name;
	@Autowired
	private List<GameImpl> gamesMade = new ArrayList<>();

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
	public List<GameImpl> getGamesMade() {
		return gamesMade;
	}

	@Override
	public void setGamesMade(List<GameImpl> gamesMade) {
		this.gamesMade = gamesMade;
	}

}
