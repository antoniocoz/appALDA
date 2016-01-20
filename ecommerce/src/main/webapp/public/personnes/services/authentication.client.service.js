// Invocar modo JavaScript 'strict'
'use strict';

// Creer le service 'personneService'
angular.module('personnes').factory('Authentication', [
   function() {
     this.user = window.user;

     return {
       user: this.user
     };
   }
 ]);