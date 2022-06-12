package com.organization.mvcproject.app.model;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Game;

@Component
public class GameImpl implements Game {

	Long id;
	String name;
	String genre;
	
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

}
