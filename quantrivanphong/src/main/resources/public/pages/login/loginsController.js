angular.module("myApp").controller("loginController", function ($scope, $http, $window, $state) {
    $scope.loginQTVP = function (login) {
        $http({
            method: 'POST',
            url: 'http://localhost:8081/login',
            data: angular.toJson($scope.login),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.view = response.data;
            if ($scope.view.status == 200) {
                $state.go('admin-home');
            }
        }
        function errorCallback(error) {
            console.log(error.data);
            if(error.data.details==null){
                alert("Mời bạn nhập đầy đủ thông tin!");
            }else{
                alert(error.data.details);
            }

        }
    }
});