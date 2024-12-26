//package com.organization.mvcproject.app.dao;
//
//
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Assertions;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.organization.mvcproject.api.mockdao.GameDAO;
//import com.organization.mvcproject.api.model.Game;
//import com.organization.mvcproject.app.model.GameImpl;
//
//@RunWith(JUnitPlatform.class)
//@ExtendWith(SpringExtension.class)
//public class MockGameDaoImplTest {
//	
//	public static final int STARTING_LENGTH = 3;
//
//	public static final long FIRSTGAME_ID = 1;
//
//	@Autowired
//	private GameDAO  mockGameDaoImpl;
//	
//	private static Game testGameAdd;
//	
//	private final long DELETE_ID = 1L;
//	
//	
//	private static final String GENRE_STRING = "Sport";
//	
//	private static Game game1 = createGameImpl(1,"Rocket League", "Sport");
//	private static Game game2 = createGameImpl(2,"Halo", "Shooter");
//	private static Game game3 = createGameImpl(3,"Runescape", "MMORPG");
//	
//	public static void deleteAllGamesFromDAO()
//	{
//		mockGameDaoImpl.resetGameList();
//	}
//	
//	@BeforeAll
//	public static void initializeTestGames()
//	{
//		testGameAdd = new GameImpl();
//		testGameAdd.setId((long) 0);
//		testGameAdd.setName("Add Game Name");
//		testGameAdd.setGenre("Add Game Genre");
//		
//		
//		deleteAllGamesFromDAO();
//		
//		
//		
//	}
//	
//	@BeforeEach
//	public void initializeMockGameDAO()
//	{
//		mockGameDaoImpl = new MockGameDaoImpl();
//		
//		
//		
//		mockGameDaoImpl.saveGame(game1);
//		mockGameDaoImpl.saveGame(game2);
//		mockGameDaoImpl.saveGame(game3);
//		
//	}
//	
//	@AfterEach
//	public void deleteEntries()
//	{
//		deleteAllGamesFromDAO();
//		
//	}
//	
//	@Test
//	public void startingListEqualsThree()
//	{
//			
//		Assertions.assertEquals(STARTING_LENGTH, getGameDaoLength());
//	}
//	
//	@Test
//	public void addGameToGameList()
//	{
//		mockGameDaoImpl.saveGame(testGameAdd);
//		
//		int length = getGameDaoLength();
//		
//		Assertions.assertEquals(STARTING_LENGTH + 1, length);
//		
//	}
//
//
//	@Test
//	public void deleteGameFromDAOById()
//	{
//		int length = getGameDaoLength();
//		
//		Assertions.assertEquals(STARTING_LENGTH, length);
//		
//		mockGameDaoImpl.deleteGame(DELETE_ID);
//		
//		length = getGameDaoLength();
//		
//		Assertions.assertEquals(STARTING_LENGTH - 1, length);
//		
//		
//	}
//	
//	@Test
//	public void getSingleSportGameUsingGenreFilter()
//	{
//		List<Game> genreFilter = mockGameDaoImpl.findGamesByGenre(GENRE_STRING);
//		
//		Assertions.assertEquals(genreFilter.size(), 1);
//		
//		GameImpl game = (GameImpl) genreFilter.get(0);
//		
//		
//		Assertions.assertEquals(GENRE_STRING, game.getGenre());
//		
//	}
//
//	@Test
//	public void getFirstGameById()
//	{
//		GameImpl game = (GameImpl) mockGameDaoImpl.findGameById(FIRSTGAME_ID);
//		
//		
//		Assertions.assertEquals(game1.getId(), game.getId());
//		
//		Assertions.assertEquals(game1.getName(), game.getName());
//		
//		Assertions.assertEquals(game1.getGenre(), game.getGenre());
//		
//	}
//	
//	
//	
//	//Methods for working with the GameDao
//	
//	
//	private int getGameDaoLength()
//	{
//		return mockGameDaoImpl.findAllGames().size();
//	}
//	
//	private static Game createGameImpl(long id, String name, String genre)
//	{
//		Game game = new GameImpl();
//		
//		game.setId(id);
//		game.setName(name);
//		game.setGenre(genre);
//		
//		return game;
//		
//	}
//	
//	
//	
//	
//}
