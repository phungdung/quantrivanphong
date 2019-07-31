/**
 *
 */
angular.module("myApp", ["ui.router","ui.bootstrap"]).config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

    $locationProvider.hashPrefix('');
    //trở về trang mặc định
    $urlRouterProvider.otherwise("/home-page");

    $stateProvider
        .state("adminLayout", {
            abstract: true,
            views: {
                "layout": {
                    templateUrl: "layout/admin-layout.html"
                }
            }
        })
        .state("homeLayout", {
            abstract: true,
            views: {
                "layout": {
                    templateUrl: "layout/home-layout.html"
                }
            }
        })
        .state("loginLayout", {
            abstract: true,
            views: {
                "layout": {
                    templateUrl: "layout/login-layout.html"
                }
            }
        })
        //home-page
        .state("home-page", {
            parent: 'homeLayout',
            url: "/home-page",
            views: {
                "content": {
                    templateUrl: "pages/home-page/home.html",
                }
            }
        })
        //end home
        .state("admin-home", {
            parent: 'adminLayout',
            url: "/admin-home",
            views: {
                "content": {
                    templateUrl: "pages/adminhome/admin-home.html",
                }
            }
        })
        .state("login", {
            parent: 'loginLayout',
            url: "/login",
            views: {
                "content": {
                    templateUrl: "pages/login/login.html",
                    controller: "loginController"
                }
            }
        })
        .state("register", {
            parent: 'loginLayout',
            url: "/register",
            views: {
                "content": {
                    templateUrl: "pages/login/register.html",
                    controller: "insertEmployee"
                }
            }
        })
        .state("forgot-password", {
            parent: 'loginLayout',
            url: "/forgot-password",
            views: {
                "content": {
                    templateUrl: "pages/login/forgot-password.html",
                    controller: "loginController"
                }
            }
        })
        //danh sách các dự án
        .state("project", {
            parent: 'adminLayout',
            url: "/project",
            views: {
                "content": {
                    templateUrl: "pages/project/projectListViews.html",
                    controller: "projectViewsController"
                }
            }
        })
        //thêm mới dự án
        .state("addproject", {
            parent: 'adminLayout',
            url: "/addproject",
            views: {
                "content": {
                    templateUrl: "pages/project/projectAddViews.html",
                    controller: "insertProject"
                }
            }
        })
        //sửa thông tin dự án
        .state("editproject", {
            parent: 'adminLayout',
            url: "/editproject/:ID",
            views: {
                "content": {
                    templateUrl: "pages/project/projectEditViews.html",
                    controller: "loadProjectDetail"
                }
            }
        })
        //danh sách thành viên trong nhóm dự án
        .state("groupProjectByProjectId", {
            parent: 'adminLayout',
            url: "/groupProjectByProjectId/:ID",
            params: {ID: null},
            views: {
                "content": {
                    templateUrl: "pages/employeeproject/groupProjectView.html",
                    controller: "groupProjectShowController"
                }
            }
        })
        //thêm thành viên vào nhóm dự án
        .state("addEmployeeProject", {
            parent: 'adminLayout',
            url: "/addEmployeeProject",
            views: {
                "content": {
                    templateUrl: "pages/employeeproject/groupProjectAddView.html",
                    controller: "insertEmployeeProject"
                }
            }
        })
        //sửa thông tin nhân viên trong nhóm
        .state("editEmployeeProject", {
            parent: 'adminLayout',
            url: "/editEmployeeProject/:ID",
            views: {
                "content": {
                    templateUrl: "pages/employeeproject/groupProjectEditView.html",
                    controller: "loadEmployeeProjectDetail"
                }
            }
        })
//    danh sách project vào các issues
        .state("issues", {
            parent: 'adminLayout',
            url: "/issues",
            views: {
                "content": {
                    templateUrl: "pages/issue/IssueView.html",
                    controller: "IssuesShowController"
                }
            }
        })
//    thêm mới issues
        .state("addIssues", {
            parent: 'adminLayout',
            url: "/addIssues",
            views: {
                "content": {
                    templateUrl: "pages/issue/IssueAdd.html",
                    controller: "IssuesAddController"
                }
            }
        })
        //    thêm mới issues
        .state("IssuesComment", {
            parent: 'adminLayout',
            url: "/issuescomment/:IssuesId",
            views: {
                "content": {
                    templateUrl: "pages/issuescomment/IssueDetailViews.html",
                    controller: "loadIssuesDetail"
                }
            }
        })
//    danh sách nhân viên
        .state("employee", {
            parent: 'adminLayout',
            url: "/employee",
            views: {
                "content": {
                    templateUrl: "pages/employee/employeeListViews.html",
                    controller: "employeeViewsController"
                }
            }
        })
//    xóa thông tin nhân viên
        .state("updateEmployee", {
            parent: 'adminLayout',
            url: "/updateEmployee",
            views: {
                "content": {
                    templateUrl: "pages/employee/employeeEditViews.html",
                    controller: "updateEmployee"
                }
            }
        })
});
