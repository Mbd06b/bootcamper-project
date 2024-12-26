package com.organization.provider.model.remote;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

public class GameRemote implements Game {

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

	@Override
	public Company getCompany() {
		 // We only store companyId in this simplified view
		return null;
	}

	@Override
	public void setCompany(Company company) {
        if (company != null) {
            this.companyId = company.getId();
        }
		
	}

	@Override
	public List<Review> getReviews() {
        return null; // Reviews are not included in this simplified view
    }

	@Override
	public void setReviews(List<Review> reviews) {
	     // No-op as we don't store reviews in this simplified view
	}
    
}
