package com.organization.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO; 
	
	// more services that are here
	
	@Override
	@Transactional
	public List<Game> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	@Override
	@Transactional
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	@Transactional
	public Game findGameById(Long id) {
		Game game = gameDAO.findGameById(id);
		game.getReviews();
		game.getCompany();
		return game;
	}

	@Override
	@Transactional
	public boolean deleteGame(Long id) {
		return gameDAO.deleteGame(id); 
	}

	@Override
	@Transactional
	public List<Game> retrieveGamesByGenre(String genre) {
		return gameDAO.findGamesByGenre(genre);
	}

}