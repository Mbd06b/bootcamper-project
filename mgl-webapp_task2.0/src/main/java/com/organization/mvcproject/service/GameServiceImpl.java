package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.GameStreamBasedDAO;
import com.organization.mvcproject.model.Game;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameStreamBasedDAO gameDAO; 

	
	public List<Game> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	
	public Game findGameById(Long id) {
		return gameDAO.findGameById(id);
	}

	
	public boolean deleteGame(Long id) {
		return gameDAO.deleteGame(id); 
	}
}
	