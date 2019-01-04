app.controller('baseController', function ($scope) {

    // 分页控件配置
    // currentPage：当前页；totalItems：总记录数；itemsPerPage：每页记录数；perPageOptions：分页选项；onChange：当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 5,
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

    //字符串转数组
    $scope.string2JsonArr = function (str, key) {
        //将str转换成json数组
        var jsonArr = JSON.parse(str);
        //遍历数组，根据key获取value
        var tempArr = [];
        for (var i = 0; i < jsonArr.length; i++) {
            tempArr.push(jsonArr[i][key]);
        }
        //获取到的值拼接成数组，以逗号隔开返回
        return tempArr.join(',');
    };
});