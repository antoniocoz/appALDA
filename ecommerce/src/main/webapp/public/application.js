var mainApplicationModuleName = 'ecommerce';

var mainApplicationModule = angular.module(mainApplicationModuleName, ['ngResource','ngRoute','utilisateurs']);

mainApplicationModule.config(['$locationProvider',
  function($locationProvider) {
    $locationProvider.hashPrefix('!');
  }
]);

angular.element(document).ready(function() {
  angular.bootstrap(document, [mainApplicationModuleName]);
});