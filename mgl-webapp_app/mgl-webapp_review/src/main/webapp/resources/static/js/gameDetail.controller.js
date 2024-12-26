'use strict';

angular.module('GameLibraryApp').controller('GameDetailsCtrl',
		[ '$routeParams','$location', 'GameLibraryService', function($routeParams, $location, GameLibraryService) {
	   var gameId = $routeParams.id;
	   var vm = this;
	   
	   GameLibraryService.getGameById(gameId).then(function(game) {
	      vm.game = game;
	    });
	    
		 vm.goBack = function() {
		    $location.path('');  
		};
			
} ]);