package com.organization.provider.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.provider.model.GameImpl;

@Repository
public class GameDAOImpl extends HibernateDaoSupport implements GameDAO  {
	
	
	@Autowired
	//@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;
	
	 GameDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory); 
	}
	
	@Override
	public List<Game> findAllGames() {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(GameImpl.class);
        return  ImmutableList.copyOf(criteria.list());
	}

	
	@Override
	public Game findGameById(Long id) {
		TypedQuery<GameImpl> query = getSessionFactory().getCurrentSession().createQuery("SELECT g FROM Game g WHERE g.id = :id", GameImpl.class);
		query.setParameter("id", id);
		return (Game) query.getSingleResult();
	}
	
	@Override
	public Game saveGame(Game game) {
		getSessionFactory().getCurrentSession().saveOrUpdate(game);
		return game; //returns with ID
	}
	

	@Override
	public boolean deleteGame(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		Game game = session.find(GameImpl.class, id);
		if(game != null) {
			session.delete(game);
			return true; 
		} 		
		return false;
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		String hql = "FROM Gmae g WHERE g.genere = :genre"; // HQL Query
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("genere", genre);
		return  ImmutableList.copyOf(query.getResultList());
	}

	


	
}
