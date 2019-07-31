angular.module("myApp").controller('IssuesShowController', function ($scope,$stateParams,$http,$state) {
    $scope.currentPage = 1
        ,$scope.numPerPage = 5
        ,$scope.maxSize = 5;
    $http.get('http://localhost:8081/danh-sach-issues').then(successCallback, errorCallback);
    function successCallback(response) {
        console.log(response.data);
        {
            $scope.ListIssues = response.data;
            $scope.numPages = function () {
                return Math.ceil($scope.ListIssues.length / $scope.numPerPage);
            };
            $scope.$watch('currentPage + numPerPage', function () {
                var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;
                $scope.pageListIssues = $scope.ListIssues.slice(begin, end);

            });
        }
    }
    function errorCallback(error) {
        //error code
        console.log("can't get data!!");
    }
    $scope.updateIssues = function (issue) {
        if (confirm("Bạn có muốn thay đổi trạng thái không ?")) {
            $http({
                method: 'PUT',
                url: 'http://localhost:8081/sua-issues',
                data: angular.toJson(issue),
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
                //error code
                console.log("can't update data!!");
            }
        }
    };
});