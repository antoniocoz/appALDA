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
            	id: $routeParams.idRole
            });
        };

        $scope.update = function() {
            $scope.role.$update(function() {
                $location.path('roles/' + $scope.role.id);
            }, function(errorResponse) {
                $scope.error = errorResponse.data.message;
            });
        };

        $scope.delete = function(role) {
            if (role) {e 
            	role.$remove(function() {
                    for (var i in $scope.role) {
                        if ($scope.roles[i] === role) {
                            $scope.roles.splice(i, 1);
                        }
                    }
                });
            } else {
                $scope.roles.$remove(function() {
                    $location.path('roles');
                });
            }
        };

    }
]);