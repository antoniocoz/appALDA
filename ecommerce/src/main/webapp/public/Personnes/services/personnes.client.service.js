// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('personnes').factory('PersonneService', ['$resource', function($resource) {
	// Utiliser le service '$resource' pour retourner un objet '$resource' personne
    return $resource('api/personnes/:id', {
        id: '@id'
    }, {
        update: {
            method: 'PUT'
        },
	    login: {
	    	method: 'POST', 
	        //params:{ email: '@email',password:'@password'}, 
            url:'api/personnes/personne'
	    }
    });
}]);