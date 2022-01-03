package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	@Qualifier("gameLoopBasedDAO")
	private GameDao gameStreamBasedDAO; 

	@Override
	public List<Game> retrieveAllGames() {
		return gameStreamBasedDAO.findAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameStreamBasedDAO.saveGame(game);
	}
	
	@Override
	public Game findGameById(Long id) {
		return gameStreamBasedDAO.findGameById(id);
	}

	@Override
	public boolean deleteGame(Long id) {
		return gameStreamBasedDAO.deleteGame(id); 
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return gameStreamBasedDAO.findGamesByGenre(genre);
	}
}
	