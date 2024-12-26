package com.organization.mvcproject.app.mockdao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.CompanyImpl;
import com.organization.mvcproject.app.model.GameImpl;
import com.organization.mvcproject.app.model.ReviewImpl;
import com.organization.mvcproject.app.model.view.CompanyView;
import com.organization.mvcproject.app.model.view.GameDetailView;
import com.organization.mvcproject.app.model.view.ReviewView;

@Profile("default")
@Repository
public class GameDAOImpl implements GameDAO  {
	
	private static Long gameId = new Long(0);
    private static Long reviewId = new Long(0);
    private static Long companyId = new Long(0);

	private static List<GameImpl> games = new ArrayList<>();
    private static List<ReviewImpl> reviews = new ArrayList<>();
    private static List<CompanyImpl> companies = new ArrayList<>(); 


	static {
		games = populateGames();
		reviews = populateReviews();
		companies = populateCompanies();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");
		game1.setCompanyId(1L);
		
		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");
		game2.setCompanyId(2L);


		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");
		game3.setCompanyId(3L);

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
    private static List<CompanyImpl> populateCompanies() {
        CompanyImpl company1 = new CompanyImpl(++companyId, "Psyonix");
        CompanyImpl company2 = new CompanyImpl(++companyId, "Bungie");
        CompanyImpl company3 = new CompanyImpl(++companyId, "Jagex");
        
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        return companies;
    }
	
    private static List<ReviewImpl> populateReviews() {
        ReviewImpl review1 = new ReviewImpl(++reviewId, "Great game!", "John Doe", 5, 1L);
        ReviewImpl review2 = new ReviewImpl(++reviewId, "Addictive gameplay", "Jane Smith", 4, 1L);
        ReviewImpl review3 = new ReviewImpl(++reviewId, "Fun with friends", "Mike Johnson", 5, 1L);
        
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
        return reviews;
    }
    	
	@Override
	public List<Game> findAllGames() {
		return ImmutableList.copyOf(games);
	}

	@Override
	public Game saveGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	games = games.stream()
		    		    .map(g -> g.getId().equals(game.getId()) ? (GameImpl) game : g)
		    		    .collect(Collectors.toList());
		    	return game; 
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((GameImpl) game);
        return game; 
	
	}
	
	
	
	
	public Game findGameById(Long id) {
		return games.stream()
				  .filter(game -> id.equals(game.getId()))
				  .findAny()
				  .orElse(null);
	}

	@Override
	public boolean deleteGame(Long id) {
		return games.removeIf(game -> id.equals(game.getId()));
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return games.stream()
				  .filter(game -> genre.equals(game.getGenre()))
				  .collect(Collectors.toList());
	}

    @Override
    public GameDetailView findGameDetailById(Long id) {
        GameImpl game = (GameImpl) findGameById(id);
        if (game == null) {
            return null;
        }
        
        GameDetailView gameDetailView = new GameDetailView();
        gameDetailView.setId(game.getId());
        gameDetailView.setName(game.getName());
        gameDetailView.setGenre(game.getGenre());
        
        // Find the company from the static list and convert to CompanyView
        Optional<CompanyView> companyOptional = companies.stream()
                .filter(company -> company.getId().equals(game.getCompanyId()))
                .map(CompanyView::convert)
                .findFirst();
            
            companyOptional.ifPresent(gameDetailView::setCompany);
            
            // Filter reviews from the static list based on the game ID and convert to ReviewView
            List<ReviewView> gameReviews = reviews.stream()
                .filter(review -> review.getGameId().equals(id))
                .map(ReviewView::convert)
                .collect(Collectors.toList());
            gameDetailView.setReviews(gameReviews);

        
        
        return gameDetailView;
    }
	
}
