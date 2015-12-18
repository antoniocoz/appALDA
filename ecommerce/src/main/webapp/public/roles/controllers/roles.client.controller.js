'use strict';

// Creer le controller 'roleController'
angular.module('roles').controller('roleController', ['$scope', '$routeParams', '$location', 'RoleService',
    function($scope, $routeParams, $location, RoleService) {
	
        $scope.create = function() {

            var roleService = new RoleService({
                nom: this.nom,
                description: this.description
            });
        
            roleService.$save(function(response) {
                $location.path('roles/');
                console.log("save: " + roleService);
            }, function(errorResponse) {
                $scope.error = errorResponse.data.message;
                console.log($scope.error);
            });
        };

        $scope.find = function() {
            $scope.roles = RoleService.query();
        };

        $scope.findOne = function() {	
            $scope.role = RoleService.get({
            	id: $routeParams.roleId
            });         
        };

        $scope.update = function() {
            $scope.role.$update(function() {
                $location.path('roles');
            }, function(errorResponse) {
                $scope.error = errorResponse.data.message;
            });
        };

        $scope.delete = function(role) {
        	//console.log(role);
            if (role) {
            	role.$remove(function() {
                    for (var i in $scope.roles) {
                        if ($scope.roles[i].id == role.id) {
                        	//console.log(role.id);
                            $scope.roles.splice(i, 1);
                        }
                    }
                    $location.path('roles');
                });
            	
            } else {
            	$scope.role.$remove(function() {
                    $location.path('roles');
                });
            }
        };

    }
]);