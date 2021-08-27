package com.organization.mvcproject.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.model.Game;

@Repository
public class GameStreamBasedDAO  {
	
	/*
	 *  These static declarations allow us to mock a database. 
	 */
	private static Long gameId = new Long(0);
	private static List<Game> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	/*
	 *  end static declarations
	 */
	
	
	public List<Game> findAllGames() {
		return ImmutableList.copyOf(games);
	}

	
	public Game saveGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	games = games.stream()
		    		    .map(g -> g.getId().equals(game.getId()) ? (Game) game : g)
		    		    .collect(Collectors.toList());
		    	return game; 
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((Game) game);
        return game; 
	
	}
	
	
	public Game findGameById(Long id) {
		return games.stream()
				  .filter(game -> id.equals(game.getId()))
				  .findAny()
				  .orElse(null);
	}

	public boolean deleteGame(Long id) {
		return games.removeIf(game -> id.equals(game.getId()));
	}

	
	public List<Game> findGamesByGenre(String genre) {
		return games.stream()
				  .filter(game -> genre.equals(game.getGenre()))
				  .collect(Collectors.toList());
	}
	
	
}