package com.organization.provider.endpoint;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.provider.model.remote.GameDetailView;
import com.organization.provider.model.remote.GameRemote;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value="/game")
public interface GameEndpoint {
		
	@Operation(summary = "Fetch all games", description = "Retrieves all game entries from the database, optionally filtered by genre")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Games found",
	        content = @Content(mediaType = "application/json",
	            schema = @Schema(implementation = GameRemote.class))),
	    @ApiResponse(responseCode = "204", description = "No games found"),
	    @ApiResponse(responseCode = "500", description = "Internal server error")
	})
	@GetMapping(value = {""})
	public List<GameRemote> fetchAllGames(@RequestParam(required = false) String genre);
	
	@Operation(summary = "Fetch a game by ID", description = "Retrieves a game entry from the database by its ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Game found",
	            content = @Content(mediaType = "application/json",
	                    schema = @Schema(implementation = GameDetailView.class))),
	    @ApiResponse(responseCode = "404", description = "Game not found"),
	    @ApiResponse(responseCode = "500", description = "Internal server error")
	})
	@GetMapping(value = "/{id}")
	public GameDetailView fetchGameById(@PathVariable String id);

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
	public GameRemote createGame(@RequestBody GameRemote game);

    @Operation(summary = "Update a game", description = "Updates an existing game entry in the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Game updated successfully",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = GameRemote.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@PutMapping(value={""},
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public GameRemote updateGame(@RequestBody GameRemote game);
	
    @Operation(summary = "Delete a game", description = "Deletes a game entry from the database by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Game deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@DeleteMapping(value="/{id}")
	public Boolean deleteGame(@PathVariable String id);
	

	
}
