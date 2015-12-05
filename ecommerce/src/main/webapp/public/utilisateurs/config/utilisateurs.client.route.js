// Invocar modo JavaScript 'strict'
'use strict';

// Configurar el módulo routes de 'articles'
angular.module('utilisateurs').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/utilisateurs', {
			templateUrl: 'public/utilisateurs/views/list-utilisateurs.client.view.html'
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