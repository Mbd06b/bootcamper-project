package com.organization.mvcproject.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;

@Repository("mockGameDaoImpl")
public class MockGameDaoImpl implements GameDAO {

	private List<GameImpl> gameImpls = new ArrayList<GameImpl>();
	
	private Long gameId = new Long(0L);
	
	
	@Override
	public List<Game> findAllGames() {
		
		
		return ImmutableList.copyOf(gameImpls);
	}

	@Override
	public Game saveGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	for (int i = 0; i < gameImpls.size(); i++ ) {
					if(game.getId().equals(gameImpls.get(i).getId())) {
					    return gameImpls.set(i, (GameImpl) game);
					}
		    	}
		    } 
		} 
		
	    game.setId(++gameId);
        gameImpls.add((GameImpl) game);
        return game; 
	
	}

	@Override
	public Game findGameById(Long id) {
		
		//for each loop
		for (GameImpl g : gameImpls) {
			if(id.equals(g.getId())) {
				return g; 
			}
		}
		// if no game was found
		return null;
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		
		List<Game> gamesOfGenre = new ArrayList<>();
		for(int i = 0; i < gameImpls.size(); i++) {
			if( genre == gameImpls.get(i).getGenre()) {
				gamesOfGenre.add(gameImpls.get(i));
			}
		}
		
		return (gamesOfGenre.isEmpty()) ? null : gamesOfGenre;
	}

	@Override
	public boolean deleteGame(Long id) {
		
		for(int i = 0; i < gameImpls.size(); i++) {
			if( id == gameImpls.get(i).getId()) {
				gameImpls.remove(gameImpls.get(i));
				return true; 
			}
		}
		
		return false;
		
	}
	
	public void resetGameList()
	{
		
		gameImpls.clear();
		gameId = 0L;
	}

}
