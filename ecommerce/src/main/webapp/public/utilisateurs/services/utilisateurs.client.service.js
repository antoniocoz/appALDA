// Invocar modo JavaScript 'strict'
'use strict';

// Crear el service 'articles'
angular.module('utilisateurs').factory('UtilisateurService', ['$resource', function($resource) {
	// Usar el service '$resource' para devolver un objeto '$resource' article
    return $resource('api/utilisateurs/:utilisateurId', {
        articleId: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);