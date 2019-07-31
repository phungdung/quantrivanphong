var app = angular.module('myApp');
// app.controller('showProject', showProject);
app.controller('insertProject', insertProject);
app.controller('deleteProject', deleteProject);
app.controller('updateProject', updateProject);
app.controller('loadProjectDetail', loadProjectDetail);

//	controlers tạo Get API
// function showProject($scope, $http) {
//     $scope.lstProject = [];
//     $scope.page = 0;
//     $scope.pagesCount = 0;
//     $http.get("http://localhost:8081/quan-tri/danh-sach-du-an/" +  $scope.page + "/2").then(successCallback, errorCallback);
//
//     function successCallback(response) {
//         console.log(response.data);
//         {
//             $scope.listProject = response.data.lstResult;
//             $scope.page = response.data.page;
//             $scope.pagesCount = response.data.totalPage;
//             $scope.totalCount = response.data.totalItem;
//         }
//     }
//
//     function errorCallback(error) {
//         //error code
//         console.log("can't get data!!");
//     }
// };
// tạo controllers insert API
function insertProject($scope, $http, $state) {
    $scope.insert_project = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8081/them-du-an',
            data: angular.toJson($scope.project),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.view = response.data;
            if ($scope.view.status == 200) {
                $state.go('project');
            }
        }

        function errorCallback(error) {
            //error code
            console.log("can't insert data!!");
        }
    }
};

// delete project theo id
function deleteProject($scope, $window, $http,$state) {
    $scope.deleteProject = function (project) {
        if (confirm("Bạn có chắc chắn muốn xóa ?")) {
            $http({
                method: 'DELETE',
                url: 'http://localhost:8081/xoa-du-an',
                data: $scope.project,
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
};

//tạo controller sửa theo id
function updateProject($scope, $http, $state) {
    $scope.updateProject = function (project) {
        if (confirm("Bạn có muốn sửa không ?")) {
            $http({
                method: 'PUT',
                url: 'http://localhost:8081/sua-du-an',
                data: angular.toJson($scope.project),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);

            function successCallback(response) {
                $scope.view = response.data;
                if ($scope.view.status == 200) {
                    $state.go('project');
                }
            }

            function errorCallback(error) {
                //error code
                console.log("can't update data!!");
            }
        }
    };
};

function loadProjectDetail($scope, $stateParams, $http) {
    $http.get('http://localhost:8081/chi-tiet-du-an/' + $stateParams.ID).then(successCallback, errorCallback);

    function successCallback(response) {
        console.log(response.data);
        {
            $scope.project = response.data
        }
    }

    function errorCallback(error) {
        console.log("can't get data!!");
    }
}