// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('personnes').factory('personneService', ['$resource', function($resource) {
	// Utiliser le service '$resource' pour retourner un objet '$resource' personne
    return $resource('api/personnes/:personneId', {
        personneId: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);