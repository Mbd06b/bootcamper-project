package com.organization.mvcproject.MGLTask1.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGLTask1.model.GameImpl;
import com.organization.mvcproject.api.dao.MockGameDao;

@Repository
public class MockGameDaoImpl implements MockGameDao{

	
	private static Long gameId = new Long(0);
	@Autowired
	private static List<GameImpl> games = new ArrayList<>();

	static {games = populateGames();}

	
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
	public List<GameImpl> retrieveAllGames() {
		return games;
	}

	@Override
	public GameImpl saveGame(GameImpl game) 
	{
		if (game.getId() != null)
		{
			int index = 0;
			for (GameImpl testGame : games)
			{
				if (testGame.getId() == game.getId())
				{
					 index = games.indexOf(testGame);
					
				}
			}
			games.set(index, game);
			return game;	
			
		}
		
		
		game.setId(++gameId);
		games.add(game);
		return game;
	}
	
	@Override
	public boolean deleteGame(Long id)
	{
		if (id != null)
		{
			GameImpl removeGame = null;
			for (GameImpl game : games)
			{
				if (game.getId() == id)
				{
					removeGame = game;
				}
			}
			games.remove(removeGame);
			return true;
		} 
		
		return false;
	}
}
