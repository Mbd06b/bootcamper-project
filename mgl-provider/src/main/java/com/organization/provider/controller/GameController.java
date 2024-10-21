package com.organization.provider.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

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
import com.organization.provider.model.persistent.GameImpl;
import com.organization.provider.model.remote.GameRemote;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value="/game")
public class GameController {
	
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	
	@Autowired
	private GameService gameService;
	
	@Operation(summary = "Fetch all games", description = "Retrieves all game entries from the database, optionally filtered by genre")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Games found",
	        content = @Content(mediaType = "application/json",
	            schema = @Schema(implementation = GameRemote.class))),
	    @ApiResponse(responseCode = "204", description = "No games found"),
	    @ApiResponse(responseCode = "500", description = "Internal server error")
	})
	@GetMapping(value = {""})
	public ResponseEntity<?> fetchAllGames(@RequestParam(value="genre", required = false) String genre) {
		List<Game> gamesRetrieved; 
		if(genre != null) {
			gamesRetrieved = gameService.retrieveGamesByGenre(genre);
		} else {
			gamesRetrieved = gameService.retrieveAllGames();
		}
		if(gamesRetrieved == null || gamesRetrieved.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
//			List<GameRemote> gamesToReturn = gamesRetrieved.stream()
//					.map(GameRemote::convert)
//					.collect(Collectors.toList());
		    return new ResponseEntity<>(gamesRetrieved, HttpStatus.OK);
		}
	}
	
	@Operation(summary = "Fetch a game by ID", description = "Retrieves a game entry from the database by its ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Game found",
	            content = @Content(mediaType = "application/json",
	                    schema = @Schema(implementation = GameRemote.class))),
	    @ApiResponse(responseCode = "404", description = "Game not found"),
	    @ApiResponse(responseCode = "500", description = "Internal server error")
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> fetchGameById(@PathVariable("id") String id){
		Game game = gameService.findGameById(Long.valueOf(id));
		if(game.getId() == null) {
			logger.info("Game with id: {}, not found", id);
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(GameRemote.convert(game), HttpStatus.OK);
		
	}

    @Operation(summary = "Create a new game", description = "Creates a new game entry in the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Game created successfully",
                     content = @Content(mediaType = "application/json", 
                     schema = @Schema(implementation = GameRemote.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@PostMapping(value={""},
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createGame(@RequestBody GameRemote game) {
		Game savedGame = gameService.saveGame(GameImpl.convert(game));
		logger.info("Game id created is: {}", savedGame.getId());
		return new ResponseEntity<>(GameRemote.convert(savedGame), HttpStatus.CREATED);
	}

    @Operation(summary = "Update a game", description = "Updates an existing game entry in the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Game updated successfully",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = GameImpl.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@PutMapping(value={""},
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody GameRemote game) {
		Game savedGame = gameService.saveGame(game);
		logger.info("Updated Game is: {}", savedGame.getId());
		return new ResponseEntity<>(GameRemote.convert(savedGame), HttpStatus.OK);
	}
	
    @Operation(summary = "Delete a game", description = "Deletes a game entry from the database by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Game deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") String id){
		return new ResponseEntity<>(gameService.deleteGame(Long.valueOf(id)), HttpStatus.OK);
	}
	

	
}
