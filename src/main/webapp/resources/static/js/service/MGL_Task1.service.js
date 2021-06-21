'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', '$log', function($http, $log) {

		var REST_SERVICE_URI = 'http://localhost:8080/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'createGame', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		
		
		function deleteGame(gameId) {
			return $http.delete( REST_SERVICE_URI + gameId).then(function(response) {
				    (response.data) ? $log.debug('Game{}, Deleted', gameId): $log.debug('Game{} delete failed', gameId);
					return response.data;
				}
			);
		}
		

}]);
