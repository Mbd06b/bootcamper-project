package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDao gameStreamBasedDAO; 

	
	public List<Game> retrieveAllGames() {
		return gameStreamBasedDAO.findAllGames();
	}

	
	public Game saveGame(Game game) {
		return gameStreamBasedDAO.saveGame(game);
	}
	
	
	public Game findGameById(Long id) {
		return gameStreamBasedDAO.findGameById(id);
	}

	
	public boolean deleteGame(Long id) {
		return gameStreamBasedDAO.deleteGame(id); 
	}
}
	