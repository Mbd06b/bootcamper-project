package com.organization.mvcproject.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	
	//TODO what is the best way to dynamically configure this bean for differnet running contexts? run arg?,  maven/spring profiles?, or Dynamically w/ Bean Factory?
//	@Qualifier("gameRemoteDAO")
	@Qualifier("gameDAOImpl")
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