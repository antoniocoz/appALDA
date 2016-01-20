// appeller en mode JavaScript 'strict'
'use strict';

// Creer le controller 'personnesController'
angular.module('annonces').controller('annonceController', ['$scope', '$routeParams', '$location', 'AnnonceService', 'Authentication',
    function($scope, $routeParams, $location, AnnonceService, Authentication) {
        // Service d'Authentication
        $scope.authentication = Authentication;

        // methode controller pour créer des personnes 
        $scope.create = function() {
            // Utiliser les champs du form pour créer un nouveau $resource personne
        	//console.log("user:"+Authentication.user)
        	
            var annonceService = new AnnonceService({
            	description: this.description,
            	adresse: this.adresse,
            	surface:this.surface,
            	ville:this.ville,
            	photo:this.photo,
            	prix:this.prix,
            	personne:Authentication.user
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
            	id: $routeParams.annonceId
            });
        };

        // methode pour recuperer un personne
        $scope.addPreferes = function(annonce) {
            // Methode 'get' de personneService pour envoyer une petition GET
        	if(annonce.observers=="" || annonce.observers== null){
        		annonce.observers=$scope.authentication.user.id;
        	}else{
        		var observers = annonce.observers.split(",");
        		if(!observers.includes($scope.authentication.user.id))
        		  annonce.observers=annonce.observers+","+$scope.authentication.user.id;
        	}
        	$scope.annonce=annonce;
        	$scope.update();
        	
        };
        
        // methode pour recuperer un personne
        $scope.acheter = function(annonce) {
        	$scope.annonce.vendu=1;
        	$scope.update();
        	
        }; 
        
        // methode pour recuperer un personne
        $scope.findEmail = function() {
            // Methode 'get' de personneService pour envoyer une petition GET
            $scope.mail=$routeParams.personneEmail
        };
        
        // methode pour recuperer un personne
        $scope.envoyerEmail = function() {
	       	 var annonceService = new AnnonceService({
	             fromEmail: this.authentication.user.mail,
	             toEmail: $scope.mail,
	             title: this.title,
	             message: this.message
	          });
	     	 
	       	   annonceService.$envoyerEmail(function(response) {
	               $location.path('annonces');
	           }, function(errorResponse) {
	         	  var erreur="Votre message n'etait pas envoie verifie si votre email est correcte";
	              $scope.error = erreur;
	           });
        	
        }; 
        
       // methode pour faire la mise a jour d'un personne
        $scope.update = function() {
            // Utiliser le methode '$update' de personneService pour envoyer une petition PUT
            $scope.annonce.$update(function() {
                // Si un personne etait bien actualise on retourne a la page d'utilisateurs 
                $location.path('annonces');
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
                    for (var i in $scope.annonces) {
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