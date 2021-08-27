package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

	Game findGameById(Long id);
	
	boolean deleteGame(Long id);

	List<Game> retrieveGamesByGenre(String genre);

}
