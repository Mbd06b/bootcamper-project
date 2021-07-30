package com.organization.mvcproject.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.app.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;
import com.organization.mvcproject.app.model.ReviewImpl;
import com.organization.mvcproject.app.api.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService javaGameService;



	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("games", "command", new GameImpl());
	}

	@RequestMapping(value = "/game/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	@RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//TODO update and delete
}