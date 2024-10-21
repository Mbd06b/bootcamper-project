package com.organization.mvcproject.app.mockdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.view.GameDetailView;
import com.organization.provider.endpoint.GameEndpoint;

@Service
public class GameFeignDAO implements GameDAO {
	
	
	@Autowired
	GameEndpoint gameEndpoint;

	@Override
	public List<Game> findAllGames() {
		return ImmutableList.copyOf(gameEndpoint.fetchAllGames(null));
	}

	@Override
	public Game saveGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameDetailView findGameDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteGame(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Game findGameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
