angular.module("myApp").controller('IssuesAddController', function ($scope,$state,$http) {
        $scope.insertIssues = function (Issues) {
            $http({
                method: 'POST',
                url: 'http://localhost:8081/them-issues',
                data: angular.toJson($scope.Issues),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);

            function successCallback(response) {
                $scope.view = response.data;
                if ($scope.view.status == 200) {
                    $state.go('issues');
                }
            }

            function errorCallback(error) {
                //error code
                console.log("can't insert data!!");
            }
        }
        $http.get("http://localhost:8081/danh-sach-du-an/").then(successCallback, errorCallback);

        function successCallback(response) {
            console.log(response.data);
            {
                $scope.listProject = response.data;
            }
        }

        function errorCallback(error) {
            //error code
            console.log("can't get data!!");
        }
});