package com.organization.mvcproject.api.model;

public interface Game {

	//modifiers are implicitly public in an interface
	Long getId();
	void setId(Long id);
	String getName();
	void setName(String name);
	String getGenre();
	void setGenre(String genre);
	
}
