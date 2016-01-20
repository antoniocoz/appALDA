// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('notifications').factory('NotificationService', ['$resource', function($resource) {
	// Utiliser le service '$resource' pour retourner un objet '$resource' personne
    return $resource('api/emails/:id', {
        id: '@id'
    }, {
        update: {
            method: 'PUT'
        },
        getByEmail: {
      	  method: 'GET', 
            params:{ email: '@email'}, 
            url:'api/emails/byEmail',
            isArray:true
        }
    });
}]);