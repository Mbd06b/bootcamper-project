package com.organization.mvcproject.app.mockdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.app.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;
import com.organization.mvcproject.app.service.GameServiceImpl;

@Repository
public class MockGameDAO {
	
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();
	//Create, read, update,delete

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
	
	public List<Game> retrieveAllGames() {
		return ImmutableList.copyOf(games);
	}

	
	public Game saveGame(Game game) {
		game.setId(++gameId);
		games.add((GameImpl)game);
		return game;
	}
	/*public Game updateByName(String name,String genre) {
		if(game.getName().equals(name)) {
			game.setGenre(genre);
			return game;
		}
		
		public Game updateGame(String name,String genre) {
			for(GameImpl game: games) {
			if(game.getName().equals(name)) {
			game.setName(name);
			game.setGenre(genre);
			return game;
			}
			}
			return null;
			}
			*/
	}
	
	

    



}
