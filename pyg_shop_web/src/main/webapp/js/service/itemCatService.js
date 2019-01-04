//服务层
app.service('itemCatService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../itemCat/findAll');
    };
    //分页
    this.findPage = function (page, rows) {
        return $http.get('../itemCat/findPage/' + page + '/' + rows);
    };
    //查询实体
    this.findOne = function (id) {
        return $http.get('../itemCat/findOne/' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../itemCat/add', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../itemCat/update', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../itemCat/delete/' + ids);
    };
    //搜索
    this.search = function (page, rows, searchEntity) {
        return $http.post('../itemCat/search/' + page + "/" + rows, searchEntity);
    };
    //根据parentId查询下级分类
    this.findItemCatByParentId = function (parentId) {
        return $http.post('../itemCat/findItemCatByParentId/' + parentId);
    }

});
