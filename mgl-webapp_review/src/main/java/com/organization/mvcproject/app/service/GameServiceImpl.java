package com.organization.mvcproject.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO; 
	
	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	public Game findGameById(Long id) {
		return gameDAO.findGameById(id);
	}

	@Override
	public boolean deleteGame(Long id) {
		return gameDAO.deleteGame(id); 
	}

	@Override
	public List<Game> retrieveGamesByGenre(String genre) {
		return gameDAO.findGamesByGenre(genre);
	}

}