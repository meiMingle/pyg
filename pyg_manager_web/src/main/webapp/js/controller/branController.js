app.controller('brandController', function ($scope, $http, brandService) {
    $scope.findAll = function () {
        brandService.findAll().success(function (res) {
            $scope.list = res;
        });
    };
    // 分页控件配置
    // currentPage：当前页；totalItems：总记录数；itemsPerPage：每页记录数；perPageOptions：分页选项；onChange：当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.selectIds = [];//切换页码清空复选框
    };

    $scope.findPage = function (page, size) {
        brandService.findPage(page, size).success(
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
        brandService.save($scope.entity).success(function (res) {
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
        brandService.findOne(id).success(function (res) {
            $scope.entity = res;
        });
    };

    $scope.selectIds = [];
    //复选框
    $scope.selectOptions = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var i = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(i, 1);
        }
    };

    //全选复选框
    /*
                $scope.selectAllOptions = function ($event) {
                    // alert($event.target.checked);

                };
                todo : 品牌管理 删除的全选全不选
    */

    /*删除*/
    $scope.delete = function () {
        //var str = $scope.selectIds.join(':');/*设置数组分割符，默认','分割*/
        brandService.delete($scope.selectIds).success(function (res) {
            if (res.success) {
                alert(res.message);
                $scope.reloadList();//刷新列表
                $scope.selectIds = [];//清空选项
            } else {
                alert(res.message);
            }
        })
    };
});