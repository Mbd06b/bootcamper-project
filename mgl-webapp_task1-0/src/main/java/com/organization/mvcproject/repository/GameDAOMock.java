package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class GameDAOMock {
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

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
	
	public List<Game> retrieveAllGames() {
		return games;
	}


	public Game saveGame(Game game) {
		
		//perform an update if the game has a valid id;
		if(game.getId() != null) {
			//we might need to update, let's see if the game with id is valid;
			Game foundGame = findGameById(game.getId());
			if(foundGame != null) {
				//update the game found in the list
				for( int i = 0; i < games.size(); i++ ) {
					if(game.getId().equals(games.get(i).getId())){
						 games.set(i,  game); 
						 //if the database made changes
						 return findGameById(game.getId()) ;
					}
				}
				
			}
		}
				
		//creating a new game, or it would overrite the id of the game not found! 
		game.setId(++gameId);
		games.add(game);
		
		
		return game;
	}

	public Boolean deleteGameById(Long idOfGameToDelete ) {
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getId().equals( idOfGameToDelete )  ) {
				games.remove(i);
				return true; 
			}
		}
		return false;
	}
	
	
	public Game findGameById(Long gameIdToFind) {
		//for each loop
		for(Game g: games) {
			if(gameIdToFind == g.getId()) {
				return g; 
			}
		}
		return null;
	}

}
