package com.organization.mvcproject.api.model;

import java.util.List;

import com.organization.mvcproject.MGLTask1.model.GameImpl;


public interface Company {

	Long getId();
	void setId(Long id);

	String getName();
	void setName(String name);

	List<GameImpl> getGamesMade();
	void setGamesMade(List<GameImpl> gamesMade);
}