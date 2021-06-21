package com.organization.mvcproject.MGLTask1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGLTask1.dao.MockGameDaoImpl;
import com.organization.mvcproject.MGLTask1.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;

@Service("javaGameService")
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDaoImpl mockGameDao;
	
	@Override
	public List<GameImpl> retrieveAllGames() {
		return mockGameDao.retrieveAllGames();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return mockGameDao.saveGame(game);
	}
	
	@Override
	public boolean deleteGame(Long id)
	{
		return mockGameDao.deleteGame(id);
	}


}