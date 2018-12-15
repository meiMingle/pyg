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
    <title>angularjs-遍历字符串数组</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>

        var app = angular.module('myapp', []);
        app.controller('myController', function ($scope) {
            $scope.testArr = [
                {id: '11', name: '百强', telephonenumber: '1222222222222'},
                {}
            ]

        })
    </script>
</head>
<body ng-app="myapp" ng-controller="myController" ng-init="username='Pa'">
<ul>
    <li ng-repeat="namey in testArr">{{$index+1}}-{{namey}}</li>

</ul>

</body>
</html>
