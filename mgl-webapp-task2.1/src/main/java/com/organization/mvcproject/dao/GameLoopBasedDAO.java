package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository("gameLoopBasedDAO")
public class GameLoopBasedDAO implements GameDao {
	
	/*
	 *  These static declarations allow us to mock a database. 
	 */
		private static Long gameId = new Long(0);
		private static List<GameImpl> gameImpls = new ArrayList<>();

		static {
			gameImpls = populateGames();
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

			gameImpls.add(game1);
			gameImpls.add(game2);
			gameImpls.add(game3);

			return gameImpls;
		}
		
		/*
		 *  end static declarations
		 */
		
		public List<Game> findAllGames() {
			return ImmutableList.copyOf(gameImpls);
		}

		
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

		public boolean deleteGame(Long id) {
				for(int i = 0; i < gameImpls.size(); i++) {
					if( id == gameImpls.get(i).getId()) {
						gameImpls.remove(gameImpls.get(i));
						return true; 
					}
				}
			return false;
		}

		
		public List<Game> findGamesByGenre(String genre) {
			//for loop
			List<Game> gamesOfGenre = new ArrayList<>();
				for(int i = 0; i < gameImpls.size(); i++) {
					if( genre == gameImpls.get(i).getGenre()) {
						gamesOfGenre.add(gameImpls.get(i));
					}
				}
				
				return (gamesOfGenre.isEmpty()) ? null : gamesOfGenre;
		}
		

}
