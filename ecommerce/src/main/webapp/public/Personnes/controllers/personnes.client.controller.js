// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('personnes').controller('personneController', ['$scope', '$routeParams', '$location', 'personneService',
    function($scope, $routeParams, $location, personneService) {
        // Service d'Authentication
        //$scope.authentication = Authentication;

        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
            var personneService = new personneService({
                titulo: this.titulo,
                contenido: this.contenido
            });

            // le methode '$save' de personneService pour envoyer une petition POST 
            personneService.$save(function(response) {
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
            $scope.personnes = personneService.query();
        };

        // methode pour recuperer un personne
        $scope.findOne = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.personne = personneService.get({
            	idPersonne: $routeParams.idPersonne
            });
        };

       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.personne.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('personnes/' + $scope.personne.idPersonne);
            }, function(errorResponse) {
            	// En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour supprimer un personne 
        $scope.delete = function(personne) {
            // si un personne est envoie dans la methode
            if (personne) {
                // Utiliser la methode '$remove' pour supprimer la personne 
            	personne.$remove(function() {
                    // Supprimer la personne de la liste d'utilisateurs
                    for (var i in $scope.personnes) {
                        if ($scope.personnes[i] === personne) {
                            $scope.personnes.splice(i, 1);
                        }
                    }
                });
            } else {
            	// En autre cas, utiliser la methode '$remove' de l'utilisateur
                $scope.personne.$remove(function() {
                    $location.path('personnes');
                });
            }
        };

    }
]);