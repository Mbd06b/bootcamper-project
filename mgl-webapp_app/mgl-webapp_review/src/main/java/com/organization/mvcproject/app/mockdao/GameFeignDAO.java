//package com.organization.mvcproject.app.mockdao;
//
//import java.util.List;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import com.organization.client.config.GameEndpointClient;
//import com.organization.mvcproject.api.mockdao.GameDAO;
//import com.organization.mvcproject.api.model.Game;
//import com.organization.mvcproject.app.model.view.GameDetailView;
//import com.organization.provider.endpoint.GameEndpoint;
//import com.organization.provider.model.remote.GameRemote;
//
//
//@Profile("feign")
//@Service
//public class GameFeignDAO implements GameDAO {
//	
//	
//	@Autowired
//	private GameEndpointClient gameEndpoint;
//
//	@Override
//	public List<Game> findAllGames() {
//        return gameEndpoint.fetchAllGames(null)
//                .stream()
//                .map(Game.class::cast).toList();  
//       }
//
//	@Override
//	public Game saveGame(Game game) {
//		return (Game) gameEndpoint.createGame(GameRemote.convert(game));
//	}
//
//	@Override
//	public GameDetailView findGameDetailById(Long id) {
//		com.organization.provider.model.remote.GameDetailView serviceGame = gameEndpoint.fetchGameById(id.toString());
//		GameDetailView viewGame = new GameDetailView(); 
//		BeanUtils.copyProperties(serviceGame, viewGame);
//		return viewGame; 
//	}
//
//	@Override
//	public List<Game> findGamesByGenre(String genre) {
//        return gameEndpoint.fetchAllGames(genre)
//                .stream()
//                .map(Game.class::cast).toList();  
//	}
//
//	@Override
//	public boolean deleteGame(Long id) {
//		return gameEndpoint.deleteGame(id.toString());
//	}
//
//	@Override
//	public Game findGameById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//
//}
