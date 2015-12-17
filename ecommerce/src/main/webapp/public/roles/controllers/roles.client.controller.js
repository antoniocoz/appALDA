// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('roles').controller('roleController', ['$scope', '$routeParams', '$location', 'roleService',
    function($scope, $routeParams, $location, roleService) {
        // Service d'Authentication
        //$scope.authentication = Authentication;

        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
            var roleService = new roleService({
                titulo: this.titulo,
                contenido: this.contenido
            });

            // le methode '$save' de personneService pour envoyer une petition POST 
            roleService.$save(function(response) {
                // Si un personne est cree du mode correct retourne a liste des personnes 
                $location.path('personnes/' + response._id);
            }, function(errorResponse) {
                // En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour recuperer une liste des personnes
        $scope.find = function() {
            // Utiliser le methode 'query' de personneService pour envoyer une petition GET
            $scope.roles = roleService.query();
        };

        // methode pour recuperer un personne
        $scope.findOne = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.role = roleService.get({
            	idPersonne: $routeParams.idPersonne
            });
        };

       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.role.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('roles/' + $scope.role.id);
            }, function(errorResponse) {
            	// En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour supprimer un personne 
        $scope.delete = function(role) {
            // si un personne est envoie dans la methode
            if (role) {
                // Utiliser la methode '$remove' pour supprimer la personne 
            	role.$remove(function() {
                    // Supprimer la personne de la liste d'utilisateurs
                    for (var i in $scope.role) {
                        if ($scope.roles[i] === role) {
                            $scope.roles.splice(i, 1);
                        }
                    }
                });
            } else {
            	// En autre cas, utiliser la methode '$remove' de l'utilisateur
                $scope.roles.$remove(function() {
                    $location.path('roles');
                });
            }
        };

    }
]);