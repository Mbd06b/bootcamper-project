package com.organization.provider.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.provider.endpoint.GameEndpoint;
import com.organization.provider.model.persistent.GameImpl;
import com.organization.provider.model.remote.GameDetailView;
import com.organization.provider.model.remote.GameRemote;


@RestController
@RequestMapping(value="/game")
public class GameController implements GameEndpoint {
	
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	
	@Autowired
	private GameService gameService;
	
	@Override
	public List<GameRemote> fetchAllGames(@RequestParam(value="genre", required = false) String genre) {
		List<Game> gamesRetrieved; 
		if(genre != null) {
			gamesRetrieved = gameService.retrieveGamesByGenre(genre);
		} else {
			gamesRetrieved = gameService.retrieveAllGames();
		}
		List<GameRemote> gamesToReturn = gamesRetrieved.stream()
				.map(GameRemote::convert)
				.collect(Collectors.toList());
	    return gamesToReturn;
	}
	
	@Override
	public GameDetailView fetchGameById(@PathVariable("id") String id){
		Game game = gameService.findGameById(Long.valueOf(id));
			return GameDetailView.convert(game);
		
	}

	@Override
	public GameRemote createGame(@RequestBody GameRemote game) {
		Game savedGame = gameService.saveGame( GameImpl.convert((Game)game));
		logger.info("Game id created is: {}", savedGame.getId());
		return GameRemote.convert(savedGame);
	}

	@Override
	public GameRemote updateGame(@RequestBody GameRemote game) {
		Game savedGame = gameService.saveGame(GameImpl.convert((Game) game));
		logger.info("Updated Game is: {}", savedGame.getId());
		return GameRemote.convert(savedGame);
	}
	
	@Override
	public Boolean deleteGame(@PathVariable("id") String id){
		return gameService.deleteGame(Long.valueOf(id));
	}
	

	
}
