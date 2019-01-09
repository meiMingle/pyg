app.service('specificationService', function ($http) {
    this.findAll = function () {
        return $http.get('../specification/findAll');
    };

    this.findPage = function (page, size) {
        return $http.get('../specification/findPage/' + page + "/" + size);
    };

    this.save = function (entity) {
        return $http.post('../specification/save', entity);
    };

    this.findOne = function (id) {
        return $http.get('../specification/findOne/' + id);
    };

    this.delete = function (selectIds) {
        return $http.get("../specification/delete/" + selectIds)
    };

    this.findSpecList = function (typeTemplateId) {

        return $http.get("../specification/findSpecList/" + typeTemplateId)
    }

});