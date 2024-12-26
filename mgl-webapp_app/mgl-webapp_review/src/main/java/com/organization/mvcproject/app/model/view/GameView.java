package com.organization.mvcproject.app.model.view;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Game;

public class GameView {

	private Long id;
	private String name;
	private String genre;
	
	private CompanyView company;
    
    public GameView() {}
    
    public GameView(Game game) {
    	BeanUtils.copyProperties(game, this);
    }
    
    public static GameView convert(Game game) {
    	if(game ==null) {
    		return new GameView();
    	}
    	if(game instanceof GameView) {
    		return (GameView) game;
    	} else {
    		return new GameView(game); 
    	}
    }
	
	public Long getId() {
		return id;
	}
	public void ListId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void ListName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void ListGenre(String genre) {
		this.genre = genre;
	}
    public CompanyView getCompany() {
        return company;
    }
    
    public void setCompany(CompanyView company) {
        this.company = company;
    }
    
}
