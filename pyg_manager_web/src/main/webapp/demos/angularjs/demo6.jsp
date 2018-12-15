<%--
  Created by IntelliJ IDEA.
  User: Ti
  Date: 2018/12/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>angularjs-事件指令[ng-click]</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>
        /*
                function myController($scope) {
                    $scope.username="Ti"
                }
        */

        var app = angular.module('myapp', []);
        app.controller('myController', function ($scope) {
            // $scope.username="Ti"
            $scope.doReset = function () {
                $scope.username = '';
            }
        })
    </script>
</head>
<body ng-app="myapp" ng-controller="myController" ng-init="username='Pa'">
姓名:<input type="text" ng-model="username" value="{{user}}">
<input type="button" ng-click="doReset();" value="重置">
<br/>
你输入的姓名是：{{username}}

</body>
</html>
