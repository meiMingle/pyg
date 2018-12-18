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

        var app = angular.module('myApp', []);
        app.controller('myController', function ($scope, $http) {
            /*
                        $http.get("./test.json").success(function (res) {
                            $scope.testArr = res;

            */
            /*
            * $http服务，它是对原生XMLHttpRequest对象的简单封装，是只能接受一个参数的方法，
            * 这个方法会返回一个promise对象，具有sccess和error两个方法。当然，我们也可以在
            * 响应返回时用then方法来处理，会得到一个特殊的参数，代表了对象的成功或失败信息，
            * 或者可以使用success和error回调代替。这样就很明晰了，then方法和success方法的
            * 主要区别就是，then方法会接受到完整的响应对象，而success则会对响应对象进行析构。
            *
            * */

            $http.get("./test.json").then(function (res) {
                /*这里的返回数据相当于XmlHttpRequest对象，带请求头请求体的*/
                $scope.testArr = res.data;
            })

        })


    </script>
</head>
<body ng-app="myApp" ng-controller="myController">
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
