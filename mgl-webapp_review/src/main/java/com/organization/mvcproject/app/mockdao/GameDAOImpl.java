package com.organization.mvcproject.app.mockdao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;

@Repository
public class GameDAOImpl implements GameDAO  {
	
	private static Long gameId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	@Override
	public List<Game> findAllGames() {
		return ImmutableList.copyOf(games);
	}

	@Override
	public Game saveGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	games = games.stream()
		    		    .map(g -> g.getId().equals(game.getId()) ? (GameImpl) game : g)
		    		    .collect(Collectors.toList());
		    	return game; 
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((GameImpl) game);
        return game; 
	
	}
	
	@Override
	public Game findGameById(Long id) {
		return games.stream()
				  .filter(game -> id.equals(game.getId()))
				  .findAny()
				  .orElse(null);
	}

	@Override
	public boolean deleteGame(Long id) {
		return games.removeIf(game -> id.equals(game.getId()));
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return games.stream()
				  .filter(game -> genre.equals(game.getGenre()))
				  .collect(Collectors.toList());
	}
	
	
}
