
var myAppModule = angular.module('MyApp',['ngRoute']);
var fnTrue,lnTrue = false;

'use strict';

/* Controllers */
 
//myAppModule.module('controllers', [])
myAppModule.controller('MyCtrl1', ['$scope', function($scope) {
    $scope.formInfo = {};
    $scope.saveData = function() {
      $scope.firstnameRequired = '';
      $scope.emailRequired = '';
      $scope.passwordRequired = '';
    
      
      if (!$scope.formInfo.firstName) {
//    	  $scope.firstnameRequired = 'Firstname required! ';
    	  fnTrue = false;
      }else{
//    	  $scope.firstnameRequired = '';
    	  fnTrue = true;
      }
      
/*     
      if (!$scope.formInfo.middleName) {
    	  $scope.middlenameRequired = 'Middlename required! ';
    	  mnTrue = false;
      }else{
    	  $scope.lastnameRequired = '';
    	  mnTrue = true;
      }
*/
      if (!$scope.formInfo.lastName) {
//        $scope.lastnameRequired = 'Lastname required! ';
        lnTrue = false;
      }else{
//    	  $scope.lastnameRequired = '';
    	  lnTrue = true;
      }
      
      if(fnTrue == true & lnTrue == true){
    	//  alert("fn ="+$scope.formInfo.firstName+"\nmn = "+$scope.formInfo.middleName+"\nln = "+$scope.formInfo.lastName);
      }
    };
  }])
  .controller('MyCtrl2', [function() {
 
  }]);

