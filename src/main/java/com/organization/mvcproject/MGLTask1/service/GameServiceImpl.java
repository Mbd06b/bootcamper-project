package com.organization.mvcproject.MGLTask1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGLTask1.dao.MockGameDao;
import com.organization.mvcproject.MGLTask1.model.Game;

@Service("javaGameService")
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDao mockGameDao;
	
	@Override
	public List<Game> retrieveAllGames() {
		return mockGameDao.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {

		return mockGameDao.saveGame(game);
	}
	
	@Override
	public List<Game> updateGame(Game game)
	{
		return mockGameDao.updateGame(game);
	}
	
	@Override
	public List<Game> deleteGame(Game game)
	{
		return mockGameDao.deleteGame(game);
	}


}