package com.organization.mvcproject.MGL_Task1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.Game;

@Service("javaGameService")
public class Game_Service_Impl implements Game_Service {

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setGame_id(++gameId);
		game1.setGame_genre("Sport");
		game1.setGame_name("Rocket League");

		Game game2 = new Game();
		game2.setGame_id(++gameId);
		game2.setGame_genre("Shooter");
		game2.setGame_name("Halo 3");

		Game game3 = new Game();
		game3.setGame_id(++gameId);
		game3.setGame_genre("MMORPG");
		game3.setGame_name("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	@Override
	public List<Game> retrieveAllGames() {
		return games;
	}

	@Override
	public Game saveGame(Game game) {
		game.setGame_id(++gameId);
		games.add(game);
		return game;
	}

	public static Long getGameId() {
		return gameId;
	}

	public static void setGameId(Long gameId) {
		Game_Service_Impl.gameId = gameId;
	}

	public static Long getCompanyId() {
		return companyId;
	}

	public static void setCompanyId(Long companyId) {
		Game_Service_Impl.companyId = companyId;
	}

	public static List<Game> getGames() {
		return games;
	}

	public static void setGames(ArrayList<Game> games) {
		Game_Service_Impl.games = games;
	}

}