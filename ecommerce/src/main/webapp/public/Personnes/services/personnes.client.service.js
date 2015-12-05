// Invocar modo JavaScript 'strict'
'use strict';

// Crear el service 'articles'
angular.module('personnes').factory('PersonneService', ['$resource', function($resource) {
	// Usar el service '$resource' para devolver un objeto '$resource' article
    return $resource('api/personnes/:personneId', {
        personneId: '@id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);