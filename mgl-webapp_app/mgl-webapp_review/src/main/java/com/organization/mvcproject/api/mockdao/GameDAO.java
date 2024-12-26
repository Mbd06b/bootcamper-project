package com.organization.mvcproject.api.mockdao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.view.GameDetailView;

public interface GameDAO {
	
	List<Game> findAllGames();

	Game saveGame(Game game);

	GameDetailView findGameDetailById(Long id);
	
	List<Game> findGamesByGenre(String genre);
	
	boolean deleteGame(Long id);

	Game findGameById(Long id);
	
}
