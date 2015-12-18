// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('annonces').controller('annonceController', ['$scope', '$routeParams', '$location', 'PersonneService',
    function($scope, $routeParams, $location, PersonneService) {
        // Service d'Authentication
        //$scope.authentication = Authentication;

        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
            var annonceService = new AnnonceService({
                titulo: this.titulo,
                contenido: this.contenido
            });

            // le methode '$save' de personneService pour envoyer une petition POST 
            annonceService.$save(function(response) {
                // Si un personne est cree du mode correct retourne a liste des personnes 
                $location.path('annonces');
            }, function(errorResponse) {
                // En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour recuperer une liste des personnes
        $scope.find = function() {
            // Utiliser le methode 'query' de personneService pour envoyer une petition GET
            $scope.annonces = AnnonceService.query();
        };

        // methode pour recuperer un personne
        $scope.findOne = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.annonce = AnnonceService.get({
            	id: $routeParams.idAnnonce
            });
        };

       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.annonce.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('annonce');
            }, function(errorResponse) {
            	// En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour supprimer un personne 
        $scope.delete = function(annonce) {
            // si un personne est envoie dans la methode
            if (annonce) {
                // Utiliser la methode '$remove' pour supprimer la personne 
            	annonce.$remove(function() {
                    // Supprimer la personne de la liste d'utilisateurs
                    for (var i in $scope.personnes) {
                        if ($scope.annonces[i].id === annonce.id) {
                            $scope.annonces.splice(i, 1);
                        }
                    }
                });
            } else {
            	// En autre cas, utiliser la methode '$remove' de l'utilisateur
                $scope.annonce.$remove(function() {
                    $location.path('personnes');
                });
            }
        };

    }
]);