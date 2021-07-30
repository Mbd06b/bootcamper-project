package com.organization.mvcproject.app.api.model;

public interface Game {
	Long getId() ;

	 void setId(Long gameId);

	 String getName() ;

	 void setName(String name);

	 String getGenre() ;

	void setGenre(String genre);

}
