// Invocar modo JavaScript 'strict'
'use strict';

// Configurer le módule routes de 'personnes'
angular.module('annonces').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/annonces', {
			templateUrl: 'public/personnes/views/list-annonces.client.view.html'
		}).
		when('/annonces/create', {
			templateUrl: 'public/personnes/views/create-annonce.client.view.html'
		}).
		when('/annonces/:personneId', {
			templateUrl: 'public/personnes/views/view-annonce.client.view.html'
		}).
		when('/annonces/:personneId/edit', {
			templateUrl: 'public/personnes/views/edit-annonce.client.view.html'
		});
	}
]);