package com.organization.provider.model.remote;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompanyRemote implements Company {
	
	private Long id;
	private String name;
	
    @JsonBackReference
	List<Game> games; 
	
    public CompanyRemote() {}

	public CompanyRemote(Company company) {
		BeanUtils.copyProperties(company, this, "games");
        if (company.getGames() != null) {
            this.games = company.getGames().stream()
                .map(GameRemote::convert)
                .collect(Collectors.toList());
        }
	}
    
	public static CompanyRemote convert(Company company) {
    	if(company ==null) {
    		return new CompanyRemote();
    	}
    	if(company instanceof CompanyRemote) {
    		return (CompanyRemote) company;
    	} else {
    		return new CompanyRemote(company); 
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

	@Override
	@JsonSerialize(contentAs=GameRemote.class)
	public List<Game> getGames() {
		return games != null ? ImmutableList.copyOf(games): null; 
	}

	@Override
	@JsonDeserialize(contentAs=GameRemote.class)
	public void setGames(List<Game> games) {
		this.games = games.stream().map(GameRemote::convert).collect(Collectors.toList()); 
	}


	
}