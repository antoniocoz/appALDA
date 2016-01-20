// Invocar modo JavaScript 'strict'
'use strict';

// Configurer le módule routes de 'personnes'
angular.module('notifications').config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/notifications', {
			templateUrl: 'public/notifications/views/list-notifications.client.view.html'
		}).
		when('/notifications/create', {
			templateUrl: 'public/notifications/views/create-notification.client.view.html'
		}).
		when('/notifications/:critereId', {
			templateUrl: 'public/notifications/views/view-notification.client.view.html'
		}).
		when('/notifications/:critereId/edit', {
			templateUrl: 'public/notifications/views/edit-notification.client.view.html'
		});
	}
]);