// Invocar modo JavaScript 'strict'
'use strict';

// Crear el controller 'articles'
angular.module('personnes').controller('personneController', ['$scope', '$routeParams', '$location', 'personneService',
    function($scope, $routeParams, $location, personneService) {
        // Exponer el service Authentication
        //$scope.authentication = Authentication;

 // Crear un nuevo método controller para crear nuevos articles
        $scope.create = function() {
            // Usar los campos form para crear un nuevo objeto $resource article
            var personneService = new personneService({
                titulo: this.titulo,
                contenido: this.contenido
            });

            // Usar el método '$save' de article para enviar una petición POST apropiada
            personneService.$save(function(response) {
                // Si un artículo fue creado de modo correcto, redireccionar al usuario a la página del artículo 
                $location.path('personnes/' + response._id);
            }, function(errorResponse) {
                // En otro caso, presentar al usuario el mensaje de error
                $scope.error = errorResponse.data.message;
            });
        };

// Crear un nuevo método controller para recuperar una lista de artículos
        $scope.find = function() {
            // Usar el método 'query' de article para enviar una petición GET apropiada
            $scope.personnes = personneService.query();
        };

        // Crear un nuevo método controller para recuperar un unico artículo
        $scope.findOne = function() {
            // Usar el método 'get' de article para enviar una petición GET apropiada
            $scope.utilisateur = personneService.get({
            	idUtilisateur: $routeParams.idUtilisateur
            });
        };

 // Crear un nuevo método controller para actualizar un único article
        $scope.update = function() {
            // Usar el método '$update' de article para enviar una petición PUT apropiada
            $scope.utilisateur.$update(function() {
                // Si un article fue actualizado de modo correcto, redirigir el user a la página del article 
                $location.path('personnes/' + $scope.utilisateur.idUtilisateur);
            }, function(errorResponse) {
                // En otro caso, presenta al user un mensaje de error
                $scope.error = errorResponse.data.message;
            });
        };

// Crear un nuevo método controller para borrar un único artículo
        $scope.delete = function(utilisateur) {
            // Si un artículo fue enviado al método, borrarlo
            if (utilisateur) {
                // Usar el método '$remove' del artículo para borrar el artículo
            	utilisateur.$remove(function() {
                    // Eliminar el artículo de la lista de artículos
                    for (var i in $scope.personnes) {
                        if ($scope.personnes[i] === utilisateur) {
                            $scope.personnes.splice(i, 1);
                        }
                    }
                });
            } else {
                // En otro caso, usar el método '$remove' de article para borrar el article
                $scope.utilisateur.$remove(function() {
                    $location.path('personnes');
                });
            }
        };

    }
]);