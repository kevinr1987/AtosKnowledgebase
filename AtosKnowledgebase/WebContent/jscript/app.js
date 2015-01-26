/** * XML Module */
angular.module('myApp.service',[]).
    factory('DataSource', ['$http',function($http){
       return {
           get: function(file,callback,transform){
                $http.get(
                    file,
                    {transformResponse:transform}
                ).
                success(function(data, status) {
                    console.log("Request succeeded");
                    callback(data);
                }).
                error(function(data, status) {
                    console.log("Request failed " + status);
                });
           }
       };
    }]);

/** * Main AngularJS Web Application */ 
var app = angular.module('myApp', [ 'ngRoute','myApp.service' ]);

/** * Configure the Routes */ app.config(['$routeProvider', function ($routeProvider) { $routeProvider 
// Pages
.when("/home", {templateUrl: "partials/home.html", controller: "PageCtrl"}) 
.when("/userList", {templateUrl: "partials/userList.html", controller: "ListPageCtrl"}) 
.when("/addUser", {templateUrl: "partials/addUser.html", controller: "AddPageCtrl"}) 
.when("/toDoList", {templateUrl: "partials/toDoList.html", controller: "ToDoListXMLCtrl"}) 

// else 404 
.otherwise({templateUrl: "partials/home.html", controller: "PageCtrl"}); }]);


/** * Controls all other Pages */ 
app.controller('PageCtrl', function ( $scope, $location, $http ) { 
	
});

app.controller('ToDoListXMLCtrl', function ( $scope, DataSource ) { 
	/*
	$scope.toDoEditForm = function(userstory){
		var formTag = document.getElementById("toDoEditForm");
		if(formTag.style.display != 'block'){
			formTag.style.display = 'block';
		}else{
			formTag.style.display = 'none';
		}
	};
	*/
	$scope.toggleDone = function(){
		var btn = document.getElementById("toggleDoneButton").checked;
		var doneTasks = document.getElementsByClassName("Klaar");
		
		if(btn == false){
			for(var i=0; i<doneTasks.length;i++){
				doneTasks[i].style.display = 'none';
			}
		}else{
			for(var i=0; i<doneTasks.length;i++){
				doneTasks[i].style.display = 'table-row';
			}
		}
	};
    
	$scope.toggleAdvSearch = function(){
		if($scope.ngHide == true){
			$scope.ngHide = false;
		}else{
			$scope.ngHide = true;
		}
	};
	
	$scope.sprintSelector = function(){
		var sprintSelection = $scope.selectedItem;
		$scope.loadSprint(sprintSelection);
		$scope.toggleDone(); // Waarom doet deze regel het niet??
	};
	
	$scope.onload = function(){
		$scope.orderByField = 'status';
		$scope.reverseSort = true;
	};
	
	$scope.loadSprint = function(value){
		var file_ext = ".xml";
		var file_folder = "userstories/";
		var SOURCE_FILE = file_folder + "sprint"+ value + file_ext;
		
		if(value == "2_"){
			$scope.sprintNumber = "2";
		}else{
			$scope.sprintNumber = value;
		}
		
		xmlTransform = function(data) {
			console.log("transform data");
			var x2js = new X2JS();
			var json = x2js.xml_str2json( data );
			
			return json.sprint.userstory;
		};
		
		setData = function(data) {
			$scope.dataSet = data;
		};
		
		DataSource.get(SOURCE_FILE,setData,xmlTransform);
	}
});

app.controller('AddPageCtrl', function ( $scope, $location, $http ) {
    var config = {
      '.chosen-select' : {},
      '.chosen-select-deselect' : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width' : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
});

app.controller('ListPageCtrl', function getUsers($scope,$http) {
	$http.get("rest/add/getusers").success(function(response) {$scope.users = response;});
});