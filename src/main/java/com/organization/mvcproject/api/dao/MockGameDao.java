package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.MGLTask1.model.GameImpl;


public interface MockGameDao {
	
	List<GameImpl> retrieveAllGames();

	GameImpl saveGame(GameImpl game);
	
	boolean deleteGame(GameImpl game);

}
