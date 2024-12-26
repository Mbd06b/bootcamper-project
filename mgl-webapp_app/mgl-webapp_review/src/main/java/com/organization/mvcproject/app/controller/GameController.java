package com.organization.mvcproject.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameMananger;
import com.organization.mvcproject.app.model.GameImpl;
import com.organization.mvcproject.app.model.view.GameDetailView;


@RestController
@RequestMapping(value="/game")
public class GameController {
	
    private static Logger logger = LoggerFactory.getLogger(GameController.class);

	
	@Autowired
	private GameMananger gameMananger;
	
	@GetMapping(value = "/")
	public ResponseEntity<?> fetchAllGames(@RequestParam(value="genre", required = false) String genre) {
		if(genre != null) {
			return new ResponseEntity<>(gameMananger.retrieveGamesByGenre(genre), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(gameMananger.retrieveAllGames(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> fetchGameById(@PathVariable(value="id") String id){
		GameDetailView game = gameMananger.findGameDetailById(Long.valueOf(id));
		if(game.getId() == null) {
			logger.info("Game with id: {}, not found", id);
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(game, HttpStatus.OK);
		
	}

	@PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createGame(@RequestBody GameImpl game) {
		Game savedGame = gameMananger.saveGame(game);
		logger.info("Game id created is: {}", savedGame.getId());
		return new ResponseEntity<>((GameImpl) savedGame, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable(value="id") String id){
		return new ResponseEntity<>(gameMananger.deleteGame(Long.valueOf(id)), HttpStatus.OK);
	}
	

	
}
