package com.organization.provider.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;

@Repository
public class GameDAOImpl implements GameDAO  {
	
	
	@Autowired
    private SessionFactory sessionFactory;
//	
//	private static Long gameId = new Long(0);
//	private static List<GameImpl> games = new ArrayList<>();
//
//	static {
//		games = populateGames();
//	}
//
//	private static List<GameImpl> populateGames() {
//
//		GameImpl game1 = new GameImpl();
//		game1.setId(++gameId);
//		game1.setGenre("Sport");
//		game1.setName("Rocket League");
//
//		GameImpl game2 = new GameImpl();
//		game2.setId(++gameId);
//		game2.setGenre("Shooter");
//		game2.setName("Halo 3");
//
//		GameImpl game3 = new GameImpl();
//		game3.setId(++gameId);
//		game3.setGenre("MMORPG");
//		game3.setName("Runescape");
//
//		games.add(game1);
//		games.add(game2);
//		games.add(game3);
//
//		return games;
//	}
//	
//	@Override
//	public List<Game> findAllGames() {
//		return ImmutableList.copyOf(games);
//	}
//
//	@Override
//	public Game saveGame(Game game) {
//		if( game.getId() != null) {
//			Game foundGame = findGameById(game.getId());
//		    if(foundGame != null) {
//		    	//update the game in the list
//		    	games = games.stream()
//		    		    .map(g -> g.getId().equals(game.getId()) ? (GameImpl) game : g)
//		    		    .collect(Collectors.toList());
//		    	return game; 
//		    } 
//		} 
//		
//	    game.setId(++gameId);
//        games.add((GameImpl) game);
//        return game; 
//	
//	}
//	
//	@Override
//	public Game findGameById(Long id) {
//		return games.stream()
//				  .filter(game -> id.equals(game.getId()))
//				  .findAny()
//				  .orElse(null);
//	}
//
//	@Override
//	public boolean deleteGame(Long id) {
//		return games.removeIf(game -> id.equals(game.getId()));
//	}
//
//	@Override
//	public List<Game> findGamesByGenre(String genre) {
//		return games.stream()
//				  .filter(game -> genre.equals(game.getGenre()))
//				  .collect(Collectors.toList());
//	}
//	


	@Override
	public Game findGameById(Long id) {
		String hql = "FROM Game g WHERE g.id = :id"; 
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("id", id);
		return (Game) query.uniqueResult();
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		String hql = "FROM Gmae g WHERE g.genere = :genre"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("genere", genre);
		return  ImmutableList.copyOf(query.getResultList());
	}

	@Override
	public Game saveGame(Game game) {
		sessionFactory.getCurrentSession().saveOrUpdate(game);
		return game; //returns with ID
	}

	@Override
	public boolean deleteGame(Long id) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM Game WHERE ID = :ID");
		query.setLong("ID", id);
		return (0 > query.executeUpdate());
	}

	@Override
	public List<Game> findAllGames() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Game.class);
        return  ImmutableList.copyOf(criteria.list());
	}
	
	
}
