var app = angular.module('myApp');
// app.controller('showProject', showProject);
app.controller('insertEmployee', insertEmployee);
app.controller('deleteEmployee', deleteEmployee);
app.controller('updateEmployee', updateEmployee);
app.controller('loadEmployeeDetail', loadEmployeeDetail);
function insertEmployee($scope, $http, $state) {
    $scope.insert_Employee = function (employee) {
        $http({
            method: 'POST',
            url: 'http://localhost:8081/register',
            data: angular.toJson($scope.employee),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.view = response.data;
            if ($scope.view.status == 200) {
                $state.go('employee');
            }
        }

        function errorCallback(error) {
            //error code
            console.log("can't insert data!!");
            if(error.data.details==null){
                alert("Mời bạn nhập đầy đủ thông tin!");
            }else{
                alert(error.data.details);
            }
        }
    }
};

// delete project theo id
function deleteEmployee($scope, $window, $http,$state) {
    $scope.deleteEmployee = function (employee) {
        if (confirm("Bạn có chắc chắn muốn xóa ?")) {
            $http({
                method: 'DELETE',
                url: 'http://localhost:8081/xoa-thong-tin-nhan-vien',
                data: $scope.employee,
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
function updateEmployee($scope, $http, $state) {
    $scope.updateEmployee = function (employee) {
        if (confirm("Bạn có muốn sửa không ?")) {
            $http({
                method: 'PUT',
                url: 'http://localhost:8081/cap-nhat-thong-tin-nhan-vien',
                data: angular.toJson($scope.employee),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(successCallback, errorCallback);

            function successCallback(response) {
                $scope.view = response.data;
                if ($scope.view.status == 200) {
                    $state.go('employee');
                }
            }

            function errorCallback(error) {
                //error code
                console.log("can't update data!!");
            }
        }
    };
};

function loadEmployeeDetail($scope, $stateParams, $http) {
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