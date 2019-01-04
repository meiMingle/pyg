//服务层
app.service('goodsDescService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../goodsDesc/findAll');
    };
    //分页
    this.findPage = function (page, rows) {
        return $http.get('../goodsDesc/findPage/' + page + '/' + rows);
    };
    //查询实体
    this.findOne = function (id) {
        return $http.get('../goodsDesc/findOne/' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../goodsDesc/add', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../goodsDesc/update', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../goodsDesc/delete/' + ids);
    };
    //搜索
    this.search = function (page, rows, searchEntity) {
        return $http.post('../goodsDesc/search/' + page + "/" + rows, searchEntity);
    }
});
