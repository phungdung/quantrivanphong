angular.module("myApp").controller('groupProjectShowController', function ($scope,$stateParams,$http) {
    $scope.currentPage = 1
        ,$scope.numPerPage = 2
        ,$scope.maxSize = 5;
    $http.get('http://localhost:8081/thong-tin-du-an/'+ $stateParams.ID).then(successCallback, errorCallback);
    function successCallback(response) {
        console.log(response.data);
        {
            $scope.listGruopProject = response.data;
            $scope.numPages = function () {
                return Math.ceil($scope.listGruopProject.length / $scope.numPerPage);
            };
            $scope.$watch('currentPage + numPerPage', function () {
                var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;
                $scope.pageGroupListProject = $scope.listGruopProject.slice(begin, end);

            });
        }
    }
    function errorCallback(error) {
        //error code
        console.log("can't get data!!");
    }
});