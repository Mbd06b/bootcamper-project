package com.organization.provider.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;

@Repository
public class GameDAOImpl implements GameDAO  {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Session getCurrentSession() {
		Session session = null;
		if (entityManager == null
		    || (session = entityManager.unwrap(Session.class)) == null) {

		    throw new NullPointerException();
		}
		return session;
	}

	@Override
	public Game findGameById(Long id) {
		String hql = "FROM Game g WHERE g.id = :id"; 
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		return (Game) query.uniqueResult();
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		String hql = "FROM Game g WHERE g.genre = :genre"; // HQL Query
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("genre", genre);
		return  ImmutableList.copyOf(query.getResultList());
	}

	@Override
	public Game saveGame(Game game) {
		getCurrentSession().saveOrUpdate(game);
		return game; //returns with ID
	}

	@Override
	public boolean deleteGame(Long id) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM GAME WHERE ID = :ID");
		query.setLong("ID", id);
		return (0 < query.executeUpdate());
	}

	@Override
	public List<Game> findAllGames() {
		Criteria criteria = getCurrentSession().createCriteria(Game.class);
        return  ImmutableList.copyOf(criteria.list());
	}
	
	
}
