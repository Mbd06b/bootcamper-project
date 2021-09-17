package com.organization.mvcproject.app.service;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.mockdao.GameDAOImpl;
import com.organization.mvcproject.app.model.GameImpl;


public class GameServiceImplTest {
	
	public static final int STARTING_LIST = 3;


	@Autowired
	@Qualifier("mockGameDaoImpl")
	private static MockGameDaoImpl mockGameDaoImpl = new MockGameDaoImpl();
	
	private static Game testGameAdd;
	
	private final long DELETE_ID = 1L;
	
	
	public static void deleteAllGamesFromDAO()
	{
		mockGameDaoImpl.resetGameList();
	}
	
	@BeforeClass
	public static void initializeTestGames()
	{
		testGameAdd = new GameImpl();
		testGameAdd.setId((long) 0);
		testGameAdd.setName("Add Game Name");
		testGameAdd.setGenre("Add Game Genre");
		
		
		deleteAllGamesFromDAO();
		
		
		
	}
	
	@Before
	public void initializeMockGameDAO()
	{
		mockGameDaoImpl = new MockGameDaoImpl();
		
		Game game1 = createGameImpl(1,"Rocket League", "Sport");
		Game game2 = createGameImpl(2,"Halo", "Sport");
		Game game3 = createGameImpl(3,"Runescape", "MMORPG");
		
		mockGameDaoImpl.saveGame(game1);
		mockGameDaoImpl.saveGame(game2);
		mockGameDaoImpl.saveGame(game3);
		
	}
	
	@After
	public void deleteEntries()
	{
		deleteAllGamesFromDAO();
		
	}
	
	@Test
	public void PopulateGamesEqualsThree()
	{
			
		Assert.assertEquals(STARTING_LIST, getGameDaoLength());
	}
	
	@Test
	public void AddGameToGameList()
	{
		mockGameDaoImpl.saveGame(testGameAdd);
		
		int length = getGameDaoLength();
		
		Assert.assertEquals(STARTING_LIST + 1, length);
		
	}


	
	
	@Test
	public void DeleteGameFromDAOById()
	{
		int length = getGameDaoLength();
		
		Assert.assertEquals(STARTING_LIST, length);
		
		mockGameDaoImpl.deleteGame(DELETE_ID);
		
		length = getGameDaoLength();
		
		Assert.assertEquals(STARTING_LIST - 1, length);
		
		
	}
	
	
	
	
	private int getGameDaoLength()
	{
		return mockGameDaoImpl.findAllGames().size();
	}
	
	private static Game createGameImpl(long id, String name, String genre)
	{
		Game game = new GameImpl();
		
		game.setId(id);
		game.setName(name);
		game.setGenre(genre);
		
		return game;
		
	}
}
