var app = angular.module('myApp');
app.controller('loadGroupProjectByProjectId', loadGroupProjectByProjectId);
app.controller('insertEmployeeProject', insertEmployeeProject);
app.controller('deleteEmployeeProject', deleteEmployeeProject);
app.controller('updateGroutpProject', updateGroutpProject);
app.controller('loadEmployeeProjectDetail', loadEmployeeProjectDetail);
//	controlers tạo Get API
function loadGroupProjectByProjectId($scope,$stateParams,$http) {
    $http.get('http://localhost:8081/thong-tin-du-an/'+ $stateParams.ID).then(successCallback, errorCallback);
    function successCallback(response) {
        console.log(response.data);
        {
            $scope.listGruopProject = response.data
        }
    }
    function errorCallback(error) {
        console.log("can't get data!!");
    }
}
// tạo controllers insert API
function insertEmployeeProject($scope, $http, $state) {
    $scope.insert_employeeproject = function () {
        $http({
            //khai báo type
            method: 'POST',
            //đường dẫn API
            url: 'http://localhost:8081/them-thanh-vien',
            //truyền dữ liệu nhập trên cline vào data

            data: angular.toJson($scope.employeeProject),
            //kiểu dữ liệu API
            headers: {
                'Content-Type': 'application/json'
            }
            //    kết quả trả về (THEN)
        }).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.view = response.data;
            if($scope.view.status == 200){
                $state.go('groupProjectByProjectId', {ID: $scope.employeeProject.projectId});
            }
        }
        function errorCallback(error) {
            console.log("can't insert data!!");
        }
    }
//    get Project
    $http.get("http://localhost:8081/danh-sach-du-an").then(successCallback, errorCallback);

    function successCallback(response) {
        console.log(response.data);
        {
            $scope.pGroupProject = response.data
        }
    }

    function errorCallback(error) {
        //error code
        console.log("can't get data!!");
    }
};
function deleteEmployeeProject($scope, $window, $http,$state) {
    $scope.deleteEmployeeProject = function (gruopProject) {
        if (confirm("Bạn có chắc chắn muốn xóa ?")) {
            $http({
                method: 'DELETE',
                url: 'http://localhost:8081/xoa-thanh-vien-du-an',
                data: $scope.gruopProject,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);
            function successCallback(response) {
                $scope.view = response.data;
                if($scope.view.status == 200){
                    // $window.location.reload();
                    $state.reload();
                }
            }
            function errorCallback(error) {
                console.log("can't delete data!!");
            }
        }
    };
};
function updateGroutpProject($scope, $http,$state,$window) {
    $scope.updatePositionProject = function (gruopProject) {
        if (confirm("Bạn có chắc chắn muốn sửa ?")) {
            $http({
                method: 'PUT',
                url: 'http://localhost:8081/cap-nhat-chuc-vu-thanh-vien',
                data: $scope.gruopProject,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);
            function successCallback(response) {
                $scope.view = response.data;
                if($scope.view.status == 200){
                    $state.go('groupProjectByProjectId', {ID: $scope.gruopProject.projectDTO.id});
                    // $window.location.href = 'http://localhost:8081/#/groupProjectByProjectId/'+$scope.gruopProject.projectDTO.id;
                }
            }
            function errorCallback(error) {
                console.log("can't delete data!!");
            }
        }
    };
};
function loadEmployeeProjectDetail($scope,$stateParams,$http) {
    $http.get('http://localhost:8081/chi-tiet-thanh-vien-du-an/'+ $stateParams.ID).then(successCallback, errorCallback);
    function successCallback(response) {
        console.log(response.data);
        {
            $scope.gruopProject = response.data
        }
    }
    function errorCallback(error) {
        console.log("can't get data!!");
    }
}