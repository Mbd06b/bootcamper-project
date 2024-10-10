package com.organization.provider.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String name;
	
	@OneToMany
	private List<GameImpl> gamesMade = new ArrayList<GameImpl>();

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

	public List<GameImpl> getGamesMade() {
		return gamesMade;
	}

	public void setGamesMade(List<GameImpl> gamesMade) {
		this.gamesMade = gamesMade;
	}
}