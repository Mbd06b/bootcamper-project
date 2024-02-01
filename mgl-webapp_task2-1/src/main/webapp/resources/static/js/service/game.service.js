'use strict';

angular.module('GameApp').service('GameService', ['$http','$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame,
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		//  localhost:8081/game/1  DELETE
		function deleteGame(gameId) {
			return $http.delete(REST_SERVICE_URI + gameId).then( function( response ){
				if(response.data){
				 $log.info("Successfully deleted game with id: " + gameId);  
				} else {
				 $log.debug("No Game Deleted with id: " + gameId);
				}
				return response.data; 
			});
		}

		// localhost:8081/game  UPDATE
		function updateGame(game) {
		 	return $http.put(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
}]);
