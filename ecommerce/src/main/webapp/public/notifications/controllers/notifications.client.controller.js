// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('notifications').controller('notificationController', ['$scope', '$routeParams', '$location', 'NotificationService','Authentication',
    function($scope, $routeParams, $location, NotificationService,Authentication) {
        // Service d'Authentication
        $scope.authentication = Authentication;

        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
            var notificationService = new NotificationService({
                fromEmail: this.fromEmail,
                toEmail: this.toEmail,
                title: this.title,
                message: this.message               
            });

            // le methode '$save' de personneService pour envoyer une petition POST 
            notificationService.$save(function(response) {
                // Si un personne est cree du mode correct retourne a liste des personnes 
                $location.path('notifications');
            }, function(errorResponse) {
                // En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour recuperer une liste des personnes
        $scope.find = function() {
            // Utiliser le methode 'query' de personneService pour envoyer une petition GET
        	  $scope.notifications = NotificationService.getByEmail({
              	email: $scope.authentication.user.mail
              });
        };

        // methode pour recuperer un personne
        $scope.findOne = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.notification = NotificationService.get({
            	id: $routeParams.emailId
            });
        };

       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.notification.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('notifications');
            }, function(errorResponse) {
            	// En autre cas, presenter l'utilisateur el message d'erreur
                $scope.error = errorResponse.data.message;
            });
        };

        // methode pour supprimer un personne 
        $scope.delete = function(notification) {
            // si un personne est envoie dans la methode
            if (notification) {
                // Utiliser la methode '$remove' pour supprimer la personne 
            	notification.$remove(function() {
                    // Supprimer la personne de la liste d'utilisateurs
                    for (var i in $scope.notifications) {
                        if ($scope.notifications[i].id === notification.id) {
                            $scope.notifications.splice(i, 1);
                        }
                    }
                });
            } else {
            	// En autre cas, utiliser la methode '$remove' de l'utilisateur
                $scope.notification.$remove(function() {
                    $location.path('notifications');
                });
            }
        };

    }
]);