'use strict';

// Creer le service 'roleService'
angular.module('roles').factory('RoleService', ['$resource', function($resource) {
	
    return $resource('api/roles/:id', {
    	id: '@id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);