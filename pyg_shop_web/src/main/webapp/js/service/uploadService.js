//服务层
app.service('uploadService', function ($http) {


    this.uploadFile = function () {

        //把图片封装到form里：formData
        var formData = new FormData();
        formData.append("file", file.files[0]);/*第一个‘file’这个名要与后端接受的变量名一致，第二个file与文件上传里input标签的id值一致*/
        return $http({
            method: 'post',
            url: '../file/upload',
            data: formData,
            headers: {'Content-type': undefined},
            transformRequest: angular.identity
        })


        //发送http请求
        //设置请求方式post
        //设置enctype：multpart/formdata


    }


});
