package com.organization.mvcproject.app.model.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Game;

public class GameDetailView {

	private Long id;
	private String name;
	private String genre;
	private CompanyView company;
	private List<ReviewView> reviews; 
    
    //spring requires null constructor
    public GameDetailView() {}
    
    public GameDetailView(Game game) {
    	BeanUtils.copyProperties(game, this);
    	
        if (game.getCompany() != null) {
            this.company = CompanyView.convert(game.getCompany());
        }
        
        if (game.getReviews() != null) {
            this.reviews = game.getReviews().stream()
                .map(ReviewView::convert)
                .collect(Collectors.toList());
        }
     }
    
    public static GameDetailView convert(Game game) {
    	if(game ==null) {
    		return new GameDetailView();
    	}
    	if(game instanceof GameDetailView) {
    		return (GameDetailView) game;
    	} else {
    		return new GameDetailView(game); 
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

	public CompanyView getCompany() {
		return company;
	}

	public void setCompany(CompanyView company) {
		this.company = company;
	}

	public List<ReviewView> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewView> reviews) {
		this.reviews = reviews;
	}
	
}
