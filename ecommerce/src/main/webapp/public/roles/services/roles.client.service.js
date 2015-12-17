'use strict';

// Creer le service 'roleService'
angular.module('roles').factory('RoleService', ['$resource', function($resource) {
	
    return $resource('api/roles/:roleId', {
    	roleId: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);