
var services = angular.module('MyApp',['ngResource']);
services.factory('UserFactory', function ($resource) {
    return $resource('../../src/controller/RegisterUser', {}, {
        query: {
            method: 'POST',
            params: {},
            isArray: false
        }
    });
});