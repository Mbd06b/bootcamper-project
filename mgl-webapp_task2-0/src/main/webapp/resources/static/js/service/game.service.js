'use strict';

angular.module('GameApp').service('GameService', ['$http', function($http) {

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
		function deleteGame(gameId){
		    return $http.delete(REST_SERVICE_URI, gameId).then((response)=>{
		        return response.data;
		    });
		}
		function updateGame(game){
        		    return $http.put(REST_SERVICE_URI, game).then((response)=>{
        		        return response.data;
        		    });
        		}


}]);
