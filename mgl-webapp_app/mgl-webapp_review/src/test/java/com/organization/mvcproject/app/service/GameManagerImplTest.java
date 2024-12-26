package com.organization.mvcproject.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameMananger;
import com.organization.mvcproject.app.config.MvcConfiguration;
import com.organization.mvcproject.app.model.GameImpl;


@SpringJUnitConfig(classes = MvcConfiguration.class )
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
class GameManagerImplTest {
	
	@Mock
	@Qualifier("gameDAOImpl")
	private GameDAO gameDAO; 
	
	@Autowired
	private GameMananger gameServiceUnderTest;
	
	private static Game testGame = createGame(1);
	
	private  static final String TEST_GENRE = "Test Genre";
	private static Game createGame(Integer number) {
		Game game = new GameImpl();
		 game.setName("Testing Game Name " + String.valueOf(number));
		 game.setGenre(TEST_GENRE);
		 return game;
	}
	
	private static List<Game> gamesToRemoveAfterTest = new ArrayList<>();
	
	@BeforeAll
	@Test
	void saveGameServiceSavesAndUpdatesGame() {
		if(gamesToRemoveAfterTest.isEmpty()) {
			Game game = gameServiceUnderTest.saveGame(testGame);
			assertNotNull(game.getId());
			
			//updates 
			game.setName("Testing Game Name Updated" );
			testGame = gameServiceUnderTest.saveGame(game);
			assertEquals(game, testGame);	
			gamesToRemoveAfterTest.add(testGame);
			//the saveGame works, save another game to setup list operation tests
			gamesToRemoveAfterTest.add(gameServiceUnderTest.saveGame(createGame(2)));
		}
	}
	
	
	@AfterAll
	@Test
	void deleteGameWorksAndCleanupServiceTest() {
		if(!gamesToRemoveAfterTest.isEmpty()) {
			for(Game game: gamesToRemoveAfterTest) {
				assertTrue(gameServiceUnderTest.deleteGame(game.getId()));
				
			}
			gamesToRemoveAfterTest.clear();
		}
	}
	
	@Test
	void findGameByIdReturnsTheGame() {
		Game game = gameServiceUnderTest.findGameById(testGame.getId());
		assertNotNull(game);
		assertEquals(game, testGame);
	}

	@Test
  	void retrieveAllGamesServiceReturnsGames() {
		List<Game> games = gameServiceUnderTest.retrieveAllGames(); 
		assertNotNull(games);
		assertTrue(games.size() >= 2 );
	}
	
	@Test
	void retrieveGamesByGenre() {
		List<Game> gamesOfTestGenre = gameServiceUnderTest.retrieveGamesByGenre(TEST_GENRE);
		assertNotNull(gamesOfTestGenre);
		assertTrue(gamesOfTestGenre.size() >= 2);
		assertTrue(gamesOfTestGenre.stream().allMatch(game -> TEST_GENRE.equals(game.getGenre())));
	}
	

	
	
	
	

}
