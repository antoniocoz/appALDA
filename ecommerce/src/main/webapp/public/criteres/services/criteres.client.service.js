// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('criteres').factory('CritereService', ['$resource', function($resource) {
	// Utiliser le service '$resource' pour retourner un objet '$resource' personne
    return $resource('api/criteres/:id', {
        id: '@id'
    }, {
        update: {
            method: 'PUT'
        },
        getByPersonne: {
      	  method: 'GET', 
            params:{ idPersonne: '@idPersonne'}, 
            url:'api/criteres/byPersonne',
            isArray:true
        }
    });
}]);