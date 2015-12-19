// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('personnes').controller('personneController', ['$scope', '$routeParams', '$location', 'PersonneService',
    'RoleService', function($scope, $routeParams, $location, PersonneService, RoleService) {
        // Service d'Authentication
        //$scope.authentication = Authentication;
	    $scope.roles = RoleService.query(); 
        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
            var personneService = new PersonneService({
            	prenom: this.prenom,
            	nom: this.nom,
                titulo: this.titulo,
                mail: this.mail,
                pass: this.pass,
                tel: this.tel,
                ville: this.ville,
                adresse: this.adresse,
                role: this.role
            });

            // le methode '$save' de personneService pour envoyer une petition POST 
            personneService.$save(function(response) {
                // Si un personne est cree du mode correct retourne a liste des personnes 
                $location.path('personnes');
            }, function(errorResponse) {
                // En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour recuperer une liste des personnes
        $scope.find = function() {
            // Utiliser le methode 'query' de personneService pour envoyer une petition GET
            $scope.personnes = PersonneService.query();
        };

        // methode pour recuperer un personne
        $scope.findOne = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.personne = PersonneService.get({
            	id: $routeParams.idPersonne
            });
        };

       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.personne.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('personnes');
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
                        if ($scope.personnes[i].id === personne.id) {
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