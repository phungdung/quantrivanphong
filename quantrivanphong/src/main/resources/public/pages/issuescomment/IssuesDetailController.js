var app = angular.module("myApp").controller('loadIssuesDetail', function ($scope, $stateParams, $http, $state) {

    $http.get('http://localhost:8081/chi-tiet-issues/' + $stateParams.IssuesId).then(successCallback, errorCallback);

    function successCallback(response) {
        console.log(response.data);
        {
            $scope.loadIssues = response.data
        }
    }

    function errorCallback(error) {
        console.log("can't get data!!");
    }


    $scope.saveComment = function (IssuesComment) {
        IssuesComment.issueId = $scope.loadIssues.id;
        $http({
            method: 'POST',
            url: 'http://localhost:8081/tao-comment',
            data: angular.toJson(IssuesComment),
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
            console.log("can't insert data!!");
        }

    }

    //hiện thị danh sách comment

});
app.controller('showComment',showComment)
function showComment($scope, $http) {
    //trang đang đứng trên font-end
    $scope.currentPage = 1
        //số item hiển thị trong 1 page
        , $scope.numPerPage = 4
        //tổng số page hiển thị trên thanh chọn
        , $scope.maxSize = 5;
    $http.get('http://localhost:8081/Comment/' + $scope.loadIssues.id).then(successCallback, errorCallback);

    function successCallback(response) {
        console.log(response.data);
        {
            $scope.CommentIssues = response.data
            $scope.numPages = function () {
                return Math.ceil($scope.CommentIssues.length / $scope.numPerPage);
            };
            $scope.$watch('currentPage + numPerPage', function () {
                var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;
                $scope.pageListCommentIssues = $scope.CommentIssues.slice(begin, end);

            });
        }
    }

    function errorCallback(error) {
        console.log("can't get data!!");
    }
}