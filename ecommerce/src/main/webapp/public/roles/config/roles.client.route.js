// Invocar modo JavaScript 'strict'
'use strict';

// Configurer le módule routes de 'personnes'
angular.module('roles').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/roles', {
			templateUrl: 'public/roles/views/list-roles.client.view.html'
		}).
		when('/roles/create', {
			templateUrl: 'public/roles/views/create-role.client.view.html'
		}).
		when('/roles/:roleId', {
			templateUrl: 'public/roles/views/view-role.client.view.html'
		}).
		when('/roles/:roleId/edit', {
			templateUrl: 'public/roles/views/edit-role.client.view.html'
		});
	}
]);