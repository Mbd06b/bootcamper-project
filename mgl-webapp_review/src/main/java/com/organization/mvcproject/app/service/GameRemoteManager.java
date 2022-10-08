package com.organization.mvcproject.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.organization.mvcproject.api.model.Game;

@Service
public class GameRemoteManager {


	
	Logger logger = LoggerFactory.getLogger(GameRemoteManager.class);
	
	private final String RESOURCE_URI = "/game";

	@Value("${game.service.url}")
	private String serviceBaseUrl;

	@Autowired
	private RestTemplate restTemplate;

	
	public ResponseEntity<Game> saveGame(Game job) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.postForEntity(requestUri, job, Game.class);
	}


	public ResponseEntity<List<Game>> getAllGames() {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		ResponseEntity<Game[]> jobs = restTemplate.getForEntity(
				requestUri,
				Game[].class);

		List<Game> jobsL = Arrays.stream(jobs.getBody())
				.collect(Collectors.toList());
		return new ResponseEntity<List<Game>>(jobsL, HttpStatus.OK);
	}


	public ResponseEntity<Game> getById(Long id) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.getForEntity(requestUri + "/{id}", Game.class, Long.toString(id));
	}

	
	public ResponseEntity<Game> updateGame(Long id, Game job) {		
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.exchange(requestUri + "/{id}", 
				HttpMethod.PUT,
				new HttpEntity<>(job),
				Game.class,
				Long.toString(id));

	}
}