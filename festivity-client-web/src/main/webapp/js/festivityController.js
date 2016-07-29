mainApp.controller('festivityController', function($scope, $http) {
	var url = "http://localhost:8080/festivity-api/festivity/";

	$http.get(url).success(function(response) {
		$scope.festivities = response;
		console.log(response);
	})
});