'use strict';

angular.module('GameLibraryApp').factory('GameLibraryService', ['$http', '$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame,
			filterByGenre : filterByGenre
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post( REST_SERVICE_URI, game).then(function(response) {
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
		
		function filterByGenre(genreName){
			return $http.get(REST_SERVICE_URI, {params: {genre: genreName}}).then(function(response){
				return response.data;
			})
		}

}]);
