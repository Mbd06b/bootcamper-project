package com.organization.mvcproject.app.mockdao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;

@Repository("gameRemoteDAO")
public class GameRemoteDAO implements GameDAO {


	
	Logger logger = LoggerFactory.getLogger(GameRemoteDAO.class);
	
	private final String RESOURCE_URI = "/game";

	@Value("${game.service.url}")
	private String serviceBaseUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Game saveGame(Game game) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;

		ResponseEntity<GameImpl> response = restTemplate.postForEntity(requestUri, game, GameImpl.class);
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("POST to "+ requestUri + " Unsuccessful, Saving Game: {}", game);
			return null;
		} else {
			return (Game) response.getBody();
		}
		
	}

	@Override
	public List<Game> findAllGames() {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		logger.debug("Requesting: GET[{}]", requestUri );
		ResponseEntity<GameImpl[]> response = restTemplate.getForEntity(
				requestUri,
				GameImpl[].class);
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("GET  "+ requestUri + " Unsuccessful, findAllGames: {}");
			return null;
		} else {
		 
		List<Game> games = Arrays.stream(response.getBody())
				.collect(Collectors.toList());
		
		return games;
		}
	}

	@Override
	public Game findGameById(Long id) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		logger.debug("Requesting: GET[{}]", requestUri );
		ResponseEntity<GameImpl> response =  restTemplate.getForEntity(requestUri + "/{id}", GameImpl.class, Long.toString(id));
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("GET  "+ requestUri + " Unsuccessful, findGameById: {}", id);
			return null;
		} else {
		return (Game) response.getBody();
		}
	}


	public Game updateGame(Long id, Game game) {		
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		logger.debug("Requesting: PUT[{}]: {}", requestUri, game );

		ResponseEntity<GameImpl> response = restTemplate.exchange(requestUri + "/{id}", 
				HttpMethod.PUT,
				new HttpEntity<>(game),
				GameImpl.class,
				Long.toString(id));
		
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("PUT  "+ requestUri + " Unsuccessful, updateGame: {}", game);
			return null;
		} else {
		
		return (Game) response.getBody(); 
		
		}

	}


	@Override
	public List<Game> findGamesByGenre(String genre) {
		
		//there's a more scalable way add path params but this will work. 
		String requestUri = serviceBaseUrl + RESOURCE_URI + "?genre=" + genre;
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<GameImpl[]> response = restTemplate.getForEntity(
				requestUri,
				GameImpl[].class);
		
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("GET  "+ requestUri + " Unsuccessful, findGamesByGenre: {}", genre);
			return null;
		} else {
		List<Game> games = Arrays.stream(response.getBody())
				.collect(Collectors.toList());
		
		return games; 
		}
	}


	@Override
	public boolean deleteGame(Long id) {
		String requestUri = serviceBaseUrl + RESOURCE_URI  + "/" + id;
		
		  HttpHeaders headers = new HttpHeaders();
	      HttpEntity<Boolean> entity = new HttpEntity<Boolean>(headers);
	      
		ResponseEntity<Boolean> response =  restTemplate.exchange(
				requestUri, HttpMethod.DELETE, entity,  Boolean.class);
		
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error("DELETE "+ requestUri + " Unsuccessful, deleteGame: {}", id);
			return Boolean.FALSE;
		} else {
		return response.getBody();
		}
	}
}