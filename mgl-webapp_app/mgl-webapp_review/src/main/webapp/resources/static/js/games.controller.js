'use strict';

angular.module('GameLibraryApp').controller('GameLibraryController',
		[ 'GameLibraryService', function(GameLibraryService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];
			self.genres = [{name: 'All'}]; 
			self.selectedGenre = 'All';

			self.fetchAllGames = function(){
				if(self.selectedGenre == 'All'){
					GameLibraryService.fetchAllGames().then(function(data) {
						self.games = data;
						if(self.games.length > 0){
							self.genres = parseGenres();	
						}else{
							self.genres = [{name: 'All'}];//clear
						}
					})
				} else {
					GameLibraryService.filterByGenre(self.selectedGenre).then( function(data) {
						self.games = data;
					});
				}
			}
			
			function parseGenres(){
				var strArray = [];
				var genreArray = [{name: 'All'}];
				self.games.forEach((game) =>{
					strArray.push( game.genre );
				})
				//sets cannot contain duplicate values. voila! all genres no duplictes. 
				strArray = Array.from( new Set(strArray));
				//lets make an object list for easy handling.
				strArray.forEach((genre) =>{
					genreArray.push({ name : genre });
				})
				return genreArray;
			}

			self.addGame = function(){
				return GameLibraryService.createGame(self.game).then( function() {
					self.game = {};
					self.fetchAllGames();
				});
			}
			
			self.updateGame = function (gameSelected){
				self.game = angular.copy(gameSelected);			
			}
			
			self.deleteGame = function(game){
				return GameLibraryService.deleteGame(game.id).then( function() {
					self.fetchAllGames();
				});
			}
			self.fetchAllGames();
		} ]);
