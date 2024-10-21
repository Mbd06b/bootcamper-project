package com.organization.mvcproject.api.mockdao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameDAO {
	
	List<Game> findAllGames();

	Game saveGame(Game game);

	Game findGameById(Long id);
	
	List<Game> findGamesByGenre(String genre);
	
	boolean deleteGame(Long id);
	
}
