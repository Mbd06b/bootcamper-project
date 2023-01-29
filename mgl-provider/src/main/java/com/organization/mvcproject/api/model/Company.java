package com.organization.mvcproject.api.model;

import java.util.List;


public interface Company {

	Long getId();
	void setId(Long id);
	String getName();
	void setName(String name);
	List<Game> getGamesMade();
	void setGamesMade(List<Game> gamesMade);
}