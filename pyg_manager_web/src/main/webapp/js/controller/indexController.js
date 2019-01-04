app.controller('indexController', function ($scope, $controller, indexService) {

    $controller('baseController', {$scope: $scope});

    $scope.loginUser = {};
    $scope.findUserName = function () {
        indexService.findUserName().success(function (res) {
            $scope.loginUser = res;
        });
    }
});