package com.organization.mvcproject.api.mockdao;

import java.util.List;

import com.organization.provider.model.persistent.GameImpl;

public interface GameDAO {
	
	List<GameImpl> findAllGames();

	GameImpl saveGame(GameImpl game);

	GameImpl findGameById(Long id);
	
	List<GameImpl> findGamesByGenre(String genre);
	
	boolean deleteGame(Long id);
	
}
