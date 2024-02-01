package com.organization.mvcproject.dao;

import com.organization.mvcproject.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDAO {
    private static Long gameId = new Long(0);
    private static Long companyId = new Long(0);
    private static List<Game> games = new ArrayList<Game>();

    static {
        games = populateGames();
    }

    private static List<Game> populateGames() {

        Game game1 = new Game();
        game1.setId(++gameId);
        game1.setGenre("Sport");
        game1.setName("Rocket League");

        Game game2 = new Game();
        game2.setId(++gameId);
        game2.setGenre("Shooter");
        game2.setName("Halo 3");

        Game game3 = new Game();
        game3.setId(++gameId);
        game3.setGenre("MMORPG");
        game3.setName("Runescape");

        games.add(game1);
        games.add(game2);
        games.add(game3);

        return games;
    }


    public List<Game> retrieveAllGames() {
        return games;
    }


    public Game saveGame(Game game) {
        if(game.getId() != null){
            Game foundGame = findGameById(game.getId());
        }
        game.setId(++gameId);
        games.add(game);
        return game;
    }

    public Game findGameById(Long id){
        for(Game game : games){
            if (id.equals(game.getId())){
                return game;
            }
        }
        return null;
    }
    public void deleteGame(Long id){
        for(int i = 0; i < games.size(); i++){
            if(id.equals(games.get(i).getId())){
                games.remove(games.get(i));
            }
        }
    }
    public Game updateGame(Long id){
        for(Game game : games){
//            if (game.getId() )
            System.out.println("hehe");
            return game.getId();
        }
        return null;
    }

}

