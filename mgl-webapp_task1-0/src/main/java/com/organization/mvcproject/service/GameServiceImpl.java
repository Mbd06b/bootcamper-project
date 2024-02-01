package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import com.organization.mvcproject.dao.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;


	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return null;
	}
}