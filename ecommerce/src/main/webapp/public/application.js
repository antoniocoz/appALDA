var mainApplicationModuleName = 'ecommerce';

var mainApplicationModule = angular.module(mainApplicationModuleName, ['ngResource','ngRoute','personnes','roles']);

mainApplicationModule.config(['$locationProvider',
  function($locationProvider) {
    $locationProvider.hashPrefix('!');
  }
]);

angular.element(document).ready(function() {
  angular.bootstrap(document, [mainApplicationModuleName]);
});