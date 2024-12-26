'use strict';

var app = angular.module('GameLibraryApp', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'resources/static/template/game-list.html',
      controller: 'GameLibraryController',
      controllerAs: 'ctrl'
    })
    .when('/game/:id', {
      templateUrl: 'resources/static/template/game-details.html',
      controller: 'GameDetailsCtrl',
      controllerAs: 'vm'
    })
    // ... other routes ...
    .otherwise({redirectTo: ''});
}]);