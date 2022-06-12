package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameDao {

	List<Game> findGamesByGenre(String genre);
	
	boolean deleteGame(Long id);
	
	Game saveGame(Game game);
	
	Game findGameById(Long id);

	List<Game> findAllGames();

}
