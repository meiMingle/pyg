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
    <title>angularjs-控制器</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>
        function myController($scope) {
            $scope.username = "Ti"
        }
    </script>
</head>
<body ng-app ng-controller="myController">
姓名:<input type="text" ng-model="username" value="{{user}}">
<br/>
你输入的姓名是：{{username}}

</body>
</html>
