// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('roles').factory('roleService', ['$resource', function($resource) {
	// Utiliser le service '$resource' pour retourner un objet '$resource' personne
    return $resource('api/roles/:roleId', {
        personneId: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);