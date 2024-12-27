package com.organization.provider.model.persistent;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class CompanyImpl implements Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String name;
		
    @OneToMany(targetEntity=GameImpl.class, mappedBy = "company")
    private List<Game> games;

    //spring requires null constructor
    public CompanyImpl() {}
    
    public CompanyImpl(Company game) {
    	BeanUtils.copyProperties(game, this);
    }
    
    public static CompanyImpl convert(Company game) {
    	if(game ==null) {
    		return new CompanyImpl();
    	}
    	if(game instanceof CompanyImpl companyImpl) {
    		return companyImpl;
    	} else {
    		return new CompanyImpl(game); 
    	}
    }
    
    @Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<Game> getGames() {
		return games;
	}

	@Override
	public void setGames(List<Game> games) {
		this.games = games;
	}


}