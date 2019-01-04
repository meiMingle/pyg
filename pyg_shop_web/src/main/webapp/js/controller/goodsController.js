//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, itemCatService, typeTemplateService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        goodsService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    //分页
    $scope.findPage = function (page, rows) {
        goodsService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    //查询实体
    $scope.findOne = function (id) {
        goodsService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    //保存
    $scope.save = function () {
        $scope.entity.goodsDesc.introduction = editor.html();
        var serviceObject;//服务层对象
        if ($scope.entity.goods.id != null) {//如果有ID
            serviceObject = goodsService.update($scope.entity); //修改
        } else {
            serviceObject = goodsService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //如果成功，清空页面
                    $scope.entity = {goods: {}, goodsDesc: {}, itemList: []};
                    alert(response.message);
                } else {

                    //如果失败，弹出错误信息
                    alert(response.message);
                }
            }
        );
    };


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        goodsService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    };

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        goodsService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };


    $scope.itemCat1List = [];
    /*
        $scope.entity={
            good:{
                category1Id:1,
                category2Id:2,
                category2Id:3,
                typeTemplateId:
                brandId
            },
            goodsDesc:{},
            itemList:[]
        }
    */
    //查询一级分类列表
    $scope.findItem1List = function (parentId) {
        itemCatService.findItemCatByParentId(parentId).success(function (res) {
            $scope.itemCat1List = res;

            //初始化变量
            $scope.itemCat2List = [];
            $scope.itemCat3List = [];
            $scope.entity.goods.typeTemplateId = undefined;
            $scope.brandList = [];

        })
    };
    //查询二级分类列表
    $scope.itemCat2List = [];
    $scope.$watch("entity.goods.category1Id", function (newValue, oldValue) {
        if (undefined != newValue) {
            itemCatService.findItemCatByParentId(newValue).success(function (res) {
                $scope.itemCat2List = res;


                //初始化变量
                $scope.itemCat3List = [];
                $scope.entity.goods.typeTemplateId = undefined;
                $scope.brandList = [];
            });
        }
    });

    //查询三级分类列表
    $scope.itemCat3List = [];
    $scope.$watch("entity.goods.category2Id", function (newValue, oldValue) {
        if (undefined != newValue) {
            itemCatService.findItemCatByParentId(newValue).success(function (res) {
                $scope.itemCat3List = res;

                //初始化变量
                $scope.entity.goods.typeTemplateId = undefined;
                $scope.brandList = [];
            })
        }
    });

    //查询最终分类对应模板id
    $scope.entity = {goods: {}, goodsDesc: {}, itemList: []};
    $scope.$watch("entity.goods.category3Id", function (newValue, oldValue) {
        if (undefined != newValue) {
            itemCatService.findOne(newValue).success(function (res) {
                $scope.entity.goods.typeTemplateId = res.typeId;
                //初始化变量
                $scope.brandList = [];

            })
        }
    });


    //根据模板id查询对应模板的品牌列表
    $scope.brandList = [];
    $scope.$watch("entity.goods.typeTemplateId", function (newValue, oldValue) {
        if (undefined != newValue) {
            typeTemplateService.findOne(newValue).success(function (res) {
                $scope.brandList = JSON.parse(res.brandIds);
            })
        }
    })
});	
