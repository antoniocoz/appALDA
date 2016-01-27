// Invocar modo JavaScript 'strict'
'use strict';

// Configurer le módule routes de 'personnes'
angular.module('personnes').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/login', {
			templateUrl: 'public/personnes/views/login-personne.client.view.html'
		}).
		when('/personnes', {
			templateUrl: 'public/personnes/views/list-personnes.client.view.html'
		}).
		when('/personnes/create', {
			templateUrl: 'public/personnes/views/create-personne.client.view.html'
		}).
		when('/personnes/:personneId', {
			templateUrl: 'public/personnes/views/view-personne.client.view.html'
		}).
		when('/personnes/:personneId/edit', {
			templateUrl: 'public/personnes/views/edit-personne.client.view.html'
		});
	}
]);