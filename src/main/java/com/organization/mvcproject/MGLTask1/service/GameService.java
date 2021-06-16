package com.organization.mvcproject.MGLTask1.service;

import java.util.List;

import com.organization.mvcproject.MGLTask1.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
