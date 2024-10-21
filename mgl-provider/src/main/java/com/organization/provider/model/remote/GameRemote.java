package com.organization.provider.model.remote;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GameRemote implements Game{

	private Long id;
	private String name;
	private String genre;
	
    @JsonManagedReference
	private Company company;
    
    @JsonManagedReference
	private List<Review> reviews;
	
    
    public GameRemote() {}
    
    public GameRemote(Game game) {
        BeanUtils.copyProperties(game, this, "company", "reviews");
        if (game.getCompany() != null) {
            this.company = CompanyRemote.convert(game.getCompany());
        }
        if (game.getReviews() != null) {
            this.reviews = game.getReviews().stream()
                .map(ReviewRemote::convert)
                .collect(Collectors.toList());
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

	@Override
	@JsonProperty
	@JsonSerialize(as=CompanyRemote.class)
	public Company getCompany() {
		return company != null ? (Company) company: null;
	}

	@Override
	@JsonDeserialize(as=CompanyRemote.class)
	public void setCompany(Company company) {
		this.company = CompanyRemote.convert(company);
		
	}

	@Override
	@JsonSerialize(contentAs=ReviewRemote.class)
	public List<Review> getReviews() {
		return reviews != null ? ImmutableList.copyOf(reviews): null; 
	}

	@Override
	@JsonDeserialize(contentAs = ReviewRemote.class)
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews.stream().map(ReviewRemote::convert).collect(Collectors.toList()); 
	}


    
}
