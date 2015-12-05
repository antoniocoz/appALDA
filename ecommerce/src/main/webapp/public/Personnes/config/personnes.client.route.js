// Invocar modo JavaScript 'strict'
'use strict';

// Configurar el módulo routes de 'articles'
angular.module('personnes').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/personnes', {
			templateUrl: 'public/personnes/views/list-personnes.client.view.html'
		})/*.
		when('/utilisateurs/create', {
			templateUrl: 'articles/views/create-article.client.view.html'
		}).
		when('/utilisateurs/:utilisateurId', {
			templateUrl: 'articles/views/view-article.client.view.html'
		}).
		when('/utilisateurs/:utilisateurId/edit', {
			templateUrl: 'articles/views/edit-article.client.view.html'
		})*/;
	}
]);