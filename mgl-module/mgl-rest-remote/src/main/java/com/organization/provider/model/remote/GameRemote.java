package com.organization.provider.model.remote;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Game;

public class GameRemote {

	private Long id;
	private String name;
	private String genre;
	private Long companyId;
    
    public GameRemote() {}
    
    public GameRemote(Game game) {
    	BeanUtils.copyProperties(game, this);
    	
    	if(game.getCompany() != null && game.getCompany().getId() != null) {
    		this.companyId = game.getCompany().getId(); 
    	}
    }
    
    public static GameRemote convert(Game game) {
    	if(game ==null) {
    		return new GameRemote();
    	}
    	if(game instanceof GameRemote) {
    		return (GameRemote) game;
    	} else {
    		return new GameRemote(game); 
    	}
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
    
}
