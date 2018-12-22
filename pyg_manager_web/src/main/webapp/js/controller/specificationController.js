app.controller('specificationController', function ($scope, $http, specificationService, $controller) {
    //继承父类控制器及其$scope模型
    $controller('baseController', {$scope: $scope});


    $scope.findAll = function () {
        specificationService.findAll().success(function (res) {
            $scope.list = res;
        });
    };

    $scope.findPage = function (page, size) {
        specificationService.findPage(page, size).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };


    //entity对象初始化
    $scope.entity = {};
    //保存数据的方法
    $scope.save = function () {
        specificationService.save($scope.entity).success(function (res) {
            if (res.success) {
                alert(res.message);
                $scope.reloadList();
            } else {
                alert(res.message);
            }
        });
    };
    //根据id查询某个品牌
    $scope.findOne = function (id) {
        specificationService.findOne(id).success(function (res) {
            $scope.entity = res;
        });
    };


    /*删除*/
    $scope.delete = function () {
        //var str = $scope.selectIds.join(':');/*设置数组分割符，默认','分割*/
        specificationService.delete($scope.selectIds).success(function (res) {
            if (res.success) {
                alert(res.message);
                $scope.reloadList();//刷新列表
                $scope.selectIds = [];//清空选项
            } else {
                alert(res.message);
            }
        })
    };


    //规格选项新增
    $scope.entity = {spec: {}, optionList: []};
    $scope.insertRow = function () {
        $scope.entity.optionList.push({})
    };
    //规格选项删除


    $scope.deleteRow = function (index) {
        $scope.entity.optionList.splice(index, 1);
    };

    /*//规格选项删除(另一种方法)
        $scope.deleteRow = function (option) {
            var index = $scope.entity.optionList.indexOf(option);
            $scope.entity.optionList.splice(index,1);
        };
    */
});