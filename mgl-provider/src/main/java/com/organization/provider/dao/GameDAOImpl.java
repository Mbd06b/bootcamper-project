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
		sessionFactory.openSession().saveOrUpdate(game);
		return game; //returns with ID
	}

	@Override
	public boolean deleteGame(Long id) {
		Query query = sessionFactory.openSession().createSQLQuery("DELETE FROM Game WHERE ID = :ID");
		query.setLong("ID", id);
		return (0 > query.executeUpdate());
	}

	@Override
	public List<Game> findAllGames() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Game.class);
        return  ImmutableList.copyOf(criteria.list());
	}
	
	
}
