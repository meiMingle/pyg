<%--
  Created by IntelliJ IDEA.
  User: Ti
  Date: 2018/12/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<!--使用了来自http://jquery-pagination.com的分页插件-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>angularjs模拟分页查询</title>
    <link rel="stylesheet" href="../../../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../plugins/angularjs/pagination.css">
    <script src="../../../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../../../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../../plugins/angularjs/angular.min.js"></script>
    <script src="../../../plugins/angularjs/pagination.js"></script>
    <script>
        var app = angular.module("test1", ["pagination"]);

        app.controller('testController', function ($scope, $http) {

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
            };
            $scope.findPage = function (page, size) {
                $http.get('./pagination_' + page + '.json').success(
                    function (response) {
                        $scope.list = response.rows;
                        $scope.paginationConf.totalItems = response.total;//更新总记录数
                    }
                );
            }

        });

    </script>
</head>
<body ng-app="test1" ng-controller="testController">

<%--table>((thead>tr>th*3)+(tbody>tr>td*3))--%>
<table>
    <thead>
    <tr>
        <th>主键</th>
        <th>名称</th>
        <th>首字母</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="entity in list">
        <td>{{entity.id}}</td>
        <td>{{entity.name}}</td>
        <td>{{entity.firstChar}}</td>

    </tr>
    </tbody>
</table>
<tm-pagination conf="paginationConf"></tm-pagination>
</body>
</html>