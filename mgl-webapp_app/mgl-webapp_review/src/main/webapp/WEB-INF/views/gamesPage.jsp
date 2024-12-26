<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mgl" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular-route.js"></script>
        <script src="resources/static/js/games.module.js" /></script>
        <script src="resources/static/js/games.service.js"></script>
        <script src="resources/static/js/games.controller.js"></script>
        <script src="resources/static/js/gameDetail.controller.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="GameLibraryApp" class="ng-cloak">
        <mgl:myNav/>
        <br>        
        <div ng-view></div>

    </body>
    <script type="text/javascript"></script>

    </html>