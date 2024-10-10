package com.organization.provider.controller;

import java.lang.invoke.MethodHandles;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.provider.model.GameImpl;


@RestController
@RequestMapping(value="/game")
public class GameController {
	
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = {""})
	public ResponseEntity<?> fetchAllGames(@RequestParam(required = false) String genre) {
		if(genre != null) {
			return new ResponseEntity<>(gameService.retrieveGamesByGenre(genre), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(gameService.retrieveAllGames(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> fetchGameById(@PathVariable String id){
		Game game = gameService.findGameById(Long.valueOf(id));
		if(game.getId() == null) {
			logger.info("Game with id: {}, not found", id);
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(game, HttpStatus.OK);
		
	}

	@PostMapping(value={""},
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createGame(@RequestBody GameImpl game) {
		Game savedGame = gameService.saveGame(game);
		logger.info("Game id created is: {}", savedGame.getId());
		return new ResponseEntity<>((GameImpl) savedGame, HttpStatus.CREATED);
	}

	@PutMapping(value={""},
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody GameImpl game) {
		Game savedGame = gameService.saveGame(game);
		logger.info("Updated Game is: {}", savedGame.getId());
		return new ResponseEntity<>((GameImpl) savedGame, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable String id){
		return new ResponseEntity<>(gameService.deleteGame(Long.valueOf(id)), HttpStatus.OK);
	}
	

	
}
