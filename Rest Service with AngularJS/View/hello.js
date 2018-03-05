angular.module('hello', [])
  .controller('home', function($scope, $http) {
  $http.get('http://localhost:8080/users/all.json').then(function(response) {
	  console.log("starting to fetch data....");
	  $scope.users =response.data;
  },
  function(errResponse){
	  console.error("Error while fetching data");
  })
});