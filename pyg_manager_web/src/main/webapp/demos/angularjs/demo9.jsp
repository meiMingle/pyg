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
                {id: '11', name: '百强', telephonenumber: '1222222277'},
                {id: '55', name: '成龙', telephonenumber: '12222222223'},
                {id: '88', name: '刘德华', telephonenumber: '125555666666'},
            ]

        })
    </script>
</head>
<body ng-app="myapp" ng-controller="myController" ng-init="username='Pa'">

<%--
table((thead(tr*1>th*4))+(tbody(tr*1>td*4)))
--%>

<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>ID</th>
        <th>姓名</th>
        <th>电话</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="enity in testArr">
        <td>{{$index+1}}</td>
        <td>{{enity.id}}</td>
        <td>{{enity.name}}</td>
        <td>{{enity.telephonenumber}}</td>
    </tr>
    </tbody>
</table>

</body>
</html>
