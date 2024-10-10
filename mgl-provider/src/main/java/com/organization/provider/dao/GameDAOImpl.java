package com.organization.provider.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.mockdao.GameDAO;
import com.organization.mvcproject.api.model.Game;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class GameDAOImpl implements GameDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Game findGameById(Long id) {
        return entityManager.find(Game.class, id);
    }

    @Override
    public List<Game> findGamesByGenre(String genre) {
        String jpql = "SELECT g FROM Game g WHERE g.genre = :genre";
        TypedQuery<Game> query = entityManager.createQuery(jpql, Game.class);
        query.setParameter("genre", genre);
        return ImmutableList.copyOf(query.getResultList());
    }

    @Override
    public Game saveGame(Game game) {
        if (game.getId() == null) {
            entityManager.persist(game);
            return game;
        } else {
            return entityManager.merge(game);
        }
    }

    @Override
    public boolean deleteGame(Long id) {
        Game game = entityManager.find(Game.class, id);
        if (game != null) {
            entityManager.remove(game);
            return true;
        }
        return false;
    }

    @Override
    public List<Game> findAllGames() {
        TypedQuery<Game> query = entityManager.createQuery("SELECT g FROM Game g", Game.class);
        return ImmutableList.copyOf(query.getResultList());
    }
}
