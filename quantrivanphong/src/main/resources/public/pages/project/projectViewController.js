angular.module("myApp").controller('projectViewsController', function ($scope, $http) {
    //trang đang đứng trên font-end
        $scope.currentPage = 1
        //số item hiển thị trong 1 page
        , $scope.numPerPage = 4
        //tổng số page hiển thị trên thanh chọn
        , $scope.maxSize = 5;
    $http.get("http://localhost:8081/danh-sach-du-an").then(successCallback, errorCallback);

    function successCallback(response) {
        console.log(response.data);
        {
            $scope.listProject = response.data;
            $scope.numPages = function () {
                return Math.ceil($scope.listProject.length / $scope.numPerPage);
            };
            $scope.$watch('currentPage + numPerPage', function () {
                var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;
                $scope.pageListProject = $scope.listProject.slice(begin, end);

            });
        }
    }
    function errorCallback(error) {
        console.log("can't get data!!");
    }
});