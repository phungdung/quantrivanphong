angular.module("myApp").controller('IssuesDeleteController', function($scope, $window, $http,$state) {
    $scope.IssuesDelete = function (issue) {
        if (confirm("Bạn có chắc chắn muốn xóa ?")) {
            $http({
                method: 'DELETE',
                url: 'http://localhost:8081/xoa-issues',
                data: $scope.issue,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);

            function successCallback(response) {
                $scope.view = response.data;
                if ($scope.view.status == 200) {
                    $state.reload();
                }
            }

            function errorCallback(error) {
                console.log("can't delete data!!");
            }
        }
    };
});