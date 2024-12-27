package com.organization.provider.model.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;

public class GameDetailView implements Game {

	private Long id;
	private String name;
	private String genre;
	private CompanyRemote company;
	private List<ReviewRemote> reviews; 
    
    //spring requires null constructor
    public GameDetailView() {}
    
    public GameDetailView(Game game) {
    	BeanUtils.copyProperties(game, this);
    	
        if (game.getCompany() != null) {
            this.company = CompanyRemote.convert(game.getCompany());
        }
        
        if (game.getReviews() != null) {
            this.reviews = game.getReviews().stream()
                .map(ReviewRemote::convert)
                .toList();
        }
     }
    
    public static GameDetailView convert(Game game) {
    	if(game ==null) {
    		return new GameDetailView();
    	}
    	if(game instanceof GameDetailView gameDtlView) {
    		return gameDtlView;
    	} else {
    		return new GameDetailView(game); 
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
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public Company getCompany() {
        return this.company; // Assuming CompanyRemote implements Company
    }

    @Override
    public void setCompany(Company company) {
        if (company == null) {
            this.company = null;
        } else if (company instanceof CompanyRemote) {
            this.company = (CompanyRemote) company;
        } else {
            this.company = CompanyRemote.convert(company);
        }
    }

    @Override
    public List<Review> getReviews() {
        if (this.reviews == null) {
            return null;
        }
        // Assuming ReviewRemote implements Review, create an unmodifiable view
        return new ArrayList<>(this.reviews);
    }

    @Override
    public void setReviews(List<Review> reviews) {
        if (reviews == null) {
            this.reviews = new ArrayList<>();
        } else {
            this.reviews = reviews.stream()
                .filter(review -> review != null)
                .map(ReviewRemote::convert)
                .collect(Collectors.toList());
        }
    }

    // Convenience methods for direct access to remote types
    public CompanyRemote getCompanyRemote() {
        return this.company;
    }

    public List<ReviewRemote> getReviewsRemote() {
        return reviews != null ? new ArrayList<>(reviews) : new ArrayList<>();
    }

    public void setCompanyRemote(CompanyRemote company) {
        this.company = company;
    }

    public void setReviewsRemote(List<ReviewRemote> reviews) {
        this.reviews = reviews != null ? new ArrayList<>(reviews) : new ArrayList<>();
    }
	
}
