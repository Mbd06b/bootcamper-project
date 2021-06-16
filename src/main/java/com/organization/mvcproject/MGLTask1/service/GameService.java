package com.organization.mvcproject.MGLTask1.service;

import java.util.List;

import com.organization.mvcproject.MGLTask1.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);
	
	List<Game> updateGame(Game game);
	
	List<Game> deleteGame(Game Game);


}
