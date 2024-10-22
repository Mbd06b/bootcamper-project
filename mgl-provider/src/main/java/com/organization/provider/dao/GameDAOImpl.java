package com.organization.provider.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.provider.model.persistent.GameImpl;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class GameDAOImpl extends BaseHibernateDAO implements GameDAO {

    @Override
    public GameImpl findGameById(Long id) {
        return getEntityManager().find(GameImpl.class, id);
    }
   
    
    @Override
    public List<GameImpl> findAllGames() {
        TypedQuery<GameImpl> query = entityManager.createQuery("SELECT g FROM Game g", GameImpl.class);
        return  query.getResultList();
    }
    
    @Override
    // 1. HQL (Hibernate Query Language)
    public List<GameImpl> findGamesByGenre(String genre) {
        return getCurrentSession()
            .createQuery("FROM GameImpl g WHERE g.genre = :genre", GameImpl.class)
            .setParameter("genre", genre)
            .list(); // Hibernate-native method list()
    }
        
    // 2. HQL with a JPA-style getResultList()
    public List<GameImpl> findGamesByResultGenreHQL(String genre) {
        return getCurrentSession()
            .createQuery("FROM GameImpl g WHERE g.genre = :genre", GameImpl.class)
            .setParameter("genre", genre)
            .getResultList(); // JPA-standard method, delegates to .list() 
    }
    
    //3. JPA TypedQuery approach (Type-safe)
    public List<GameImpl> findGamesByGenreJPATypedQuery(String genre) {
        String jpql = "SELECT g FROM Game g WHERE g.genre = :genre";
        TypedQuery<GameImpl> query = entityManager.createQuery(jpql, GameImpl.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }
    
    
    // 2. JPA Criteria API (More verbose but type-safe)
    public List<GameImpl> findGamesByGenreJPACriteria(String genre) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GameImpl> query = cb.createQuery(GameImpl.class);
        Root<GameImpl> root = query.from(GameImpl.class);
        
        query.select(root)
            .where(cb.equal(root.get("genre"), genre));
        
        return getEntityManager()
            .createQuery(query)
            .getResultList();
    }
    

    
    // AVOID Regular JPA Query approach (Not type-safe)
    public List<GameImpl> findGamesByGenreUntyped(String genre) {
        String jpql = "SELECT g FROM Game g WHERE g.genre = :genre";
        Query query = entityManager.createQuery(jpql);  // No type information
        query.setParameter("genre", genre);
        return query.getResultList();  // Returns List<?>
    }
    

    // 6. AVOID Native SQL Query
    @SuppressWarnings("unchecked")
    public List<GameImpl> findGamesByGenreNativeSQL(String genre) {
        return getCurrentSession()
            .createNativeQuery(
                "SELECT * FROM games WHERE genre = :genre", 
                GameImpl.class)
            .setParameter("genre", genre)
            .list();
    }
    
    

    // Prefer persist and merge methods 
    @Override
    public GameImpl saveGame(GameImpl game) {
        if (game.getId() == null) {
            entityManager.persist(game);
            return game;
        } else {
        	Game foundGame = findGameById(game.getId());
        	game.setReviews(foundGame.getReviews());
        	game.setCompany(foundGame.getCompany());
            return entityManager.merge(game);
        }
    }
    
    // AVOID Hibernate 6.0 Deprecated save/update methods
    public Game saveGameDeprecatedInHibernate6(Game game) {
        Session session = getCurrentSession();
        if (game.getId() == null) {
            session.save(game);
            return game;
        } else {
            Game foundGame = findGameById(game.getId());
            game.setReviews(foundGame.getReviews());
            game.setCompany(foundGame.getCompany());
            session.update(game);
            return game;
        }
    }
    
    // 1. HQL (Hibernate Query Language) Approach
    @Override
    public boolean deleteGame(Long id) {
        Session session = getCurrentSession();
        
        // First check if exists
        Long count = session.createQuery(
            "SELECT COUNT(g) FROM GameImpl g WHERE g.id = :id", Long.class)
            .setParameter("id", id)
            .uniqueResult();
            
        if (count > 0) {
            // Execute delete query
            
            // DO "Typed" createQuery typed query
            int deletedCount = session.createQuery(
                "DELETE FROM GameImpl g WHERE g.id = :id", Integer.class)
                .setParameter("id", id)
                .uniqueResult();
            // AVOID untyped queries, deprecated in Hibernate 6.0
//            int deletedCount = session.createQuery(
//                    "DELETE FROM GameImpl g WHERE g.id = :id")
//                    .setParameter("id", id)
//                    .executeUpdate();
            
            return deletedCount > 0;
        }
        
        return false;
    }

    // 2. JPA Approach
    public boolean deleteGameJPA(Long id) {
        Game game = entityManager.find(GameImpl.class, id);
        if (game != null) {
            entityManager.remove(game);
            return true;
        }
        return false;
    }
    
    // 3. Criteria API Approach
    public boolean deleteGameCriteria(Long id) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        
        // First check if exists
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<GameImpl> countRoot = countQuery.from(GameImpl.class);
        countQuery.select(cb.count(countRoot))
            .where(cb.equal(countRoot.get("id"), id));
            
        Long count = session.createQuery(countQuery)
            .uniqueResult();
            
        if (count > 0) {
            // Create delete criteria
            CriteriaDelete<GameImpl> deleteQuery = cb.createCriteriaDelete(GameImpl.class);
            Root<GameImpl> deleteRoot = deleteQuery.from(GameImpl.class);
            deleteQuery.where(cb.equal(deleteRoot.get("id"), id));
            
            int deletedCount = session.createMutationQuery(deleteQuery)
                .executeUpdate();
                
            return deletedCount > 0;
        }
        
        return false;
    }


}
