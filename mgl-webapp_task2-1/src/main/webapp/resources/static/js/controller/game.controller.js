'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
					self.resetForm(); 
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			
			self.deleteGame = function(gameToDelete){
				return GameService.deleteGame(gameToDelete.id).then( function() {
				 self.fetchAllGames(); 
				});	
			}
			
			self.selectGame = function(gameToUpdate){
				self.game = angular.copy(gameToUpdate); 
			}
			
			self.resetForm = function(){
			  self.game = {};

			}
			
			self.updateGame = function(){
			  return GameService.updateGame(self.game).then( function() {
				 self.fetchAllGames(); 
				});	
			}

			self.fetchAllGames();
		} ]);
