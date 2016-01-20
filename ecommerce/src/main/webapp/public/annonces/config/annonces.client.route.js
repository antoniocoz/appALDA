// Invocar modo JavaScript 'strict'
'use strict';

// Configurer le módule routes de 'personnes'
angular.module('annonces').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/annonces', {
			templateUrl: 'public/annonces/views/list-annonces.client.view.html'
		}).
		when('/annonces/create', {
			templateUrl: 'public/annonces/views/create-annonce.client.view.html'
		}).
		when('/annonces/:annonceId', {
			templateUrl: 'public/annonces/views/view-annonce.client.view.html'
		}).
		when('/annonces/:annonceId/edit', {
			templateUrl: 'public/annonces/views/edit-annonce.client.view.html'
		}).
		when('/annonces/:annonceId/view', {
			templateUrl: 'public/annonces/views/view-annonce.client.view.html'
		}).
		when('/annonces/:personneEmail/contact', {
			templateUrl: 'public/annonces/views/contact-annonce.client.view.html'
		});
	}
]);