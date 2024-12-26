package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.view.GameDetailView;

public interface GameMananger {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

	GameDetailView findGameDetailById(Long id);
	
	boolean deleteGame(Long id);

	List<Game> retrieveGamesByGenre(String genre);

	Game findGameById(Long id);

}
