angular.module('UserService',['ngResource']).
factory('User', function ($resource) {
    return $resource('../../src/rest/UserRegisterRest', {}); 
    /*{	
        query: {
            method: 'POST',
            params: {},
            isArray: false
        }
    });
    */
});