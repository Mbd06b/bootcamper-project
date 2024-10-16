package com.organization.provider.model.persistent;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Game")
@Table(name = "GAME")
public class GameImpl implements Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="GENRE")
	String genre;
	
    @ManyToOne(targetEntity=CompanyImpl.class)
    @JoinColumn(name="COMPANY_ID")
    private Company company;
    
    @OneToMany(targetEntity=ReviewImpl.class, mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
    
    //spring requires null constructor
    public GameImpl() {}
    
    public GameImpl(Game game) {
    	BeanUtils.copyProperties(game, this);
    }
    
    public static GameImpl convert(Game game) {
    	if(game ==null) {
    		return new GameImpl();
    	}
    	if(game instanceof GameImpl) {
    		return (GameImpl) game;
    	} else {
    		return new GameImpl(game); 
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
	public Company getCompany() {
        return company;
    }
    
	@Override
    public void setCompany(Company company) {
        this.company = company;
    }
    
	@Override
    public List<Review> getReviews() {
        return reviews;
    }
    
	@Override
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
