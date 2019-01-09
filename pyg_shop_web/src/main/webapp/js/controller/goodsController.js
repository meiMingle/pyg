//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, itemCatService, typeTemplateService, uploadService, specificationService) {

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
    /*entity数据结构
        $scope.entity={
            goods:{
                category1Id:1,
                category2Id:2,
                category2Id:3,
                typeTemplateId:
                brandId
            },
            goodsDesc:{
                itemImages:[] ,图片组
                customAttributeItems:[], 扩展属性数组
                specificationItems:[
                    {attributeName:
                    attributeValue:[]
                    }
                ]  选中的规格及规格选项

            },
            itemList:[
                {spec:{"机身内存":"16G","网络":"联通3G"},price:"255",stockCount:"99999",status:"1",isDefault:"1"},
                {spec:{"机身内存":"16G","网络":"联通4G"},price:"255",stockCount:"99999",status:"1",isDefault:"1"},
                {spec:{"机身内存":"16G","网络":"移动3G"},price:"255",stockCount:"99999",status:"1",isDefault:"1"}
            ]
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
    $scope.entity = {
        goods: {},
        goodsDesc: {itemImages: [], customAttributeItems: [], specificationItems: []},
        itemList: [{spec: {}, price: "255", stockCount: "99999", status: "1", isDefault: "1"}]
    };
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
                $scope.entity.goodsDesc.customAttributeItems = JSON.parse(res.customAttributeItems);
            });


            /*
                        $scope.specList:[
                            {id:1,
                            text:"网络"
                            optionList:[
                                {id:1,optionName:"3G"},
                                {id:1,optionName:"3G"},
                                {id:1,optionName:"3G"},

                            ]


                            },
                            {}


                        ]
            */

            //根据模板id查询对应的规格及规格选项
            $scope.specList = [{optionList: []}];
            specificationService.findSpecList(newValue).success(function (res) {
                $scope.specList = res;
            })
        }
    });

    $scope.image = {
        color: '',
        url: 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=='/*空黑白透明图片*/
    };
    //上传文件的方法
    $scope.uploadFile = function () {

        uploadService.uploadFile().success(function (res) {
            if (res.success) {
                $scope.image.url = res.message;
            } else {
                alert(res.message);
            }
        })

    };
    //将上传的图片保存到图片列表中
    $scope.addImageToImages = function () {
        $scope.entity.goodsDesc.itemImages.push($scope.image);
        this.imageInit();
    };


    /*图片上传并保存后的初始化*/
    $scope.imageInit = function () {
        $scope.image = undefined;//切断image的双向绑定
        $scope.image = {//初始化image
            color: '',
            url: 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=='
        };
        /*初始化清空图片上传的input内容*/
        var obj = document.getElementById('file');
        obj.outerHTML = obj.outerHTML;
    };


    //将上传的图片保存到图片列表中
    $scope.removeImageFromImages = function (index) {
        $scope.entity.goodsDesc.itemImages.splice(index, 1);
    };


    //操作规格
    $scope.selectSpecOptins = function ($event, specName, optionName) {
        //从entity.goodsDesc.specificationItems中根据specName查找对应规格对象


        var specObject = $scope.searchObjectFromList($scope.entity.goodsDesc.specificationItems, 'attributeName', specName);

        //判断是否获取到对象
        if (null != specObject) {
            //获取到规格对象
            //判断选中状态，
            if ($event.target.checked) {
                //选中，放入attributeValue数组中；
                specObject.attributeValue.push(optionName);
            } else {
                //未选中，将数据从attributeValue数组中移除
                var attrIndex = specObject.attributeValue.indexOf(optionName);
                specObject.attributeValue.splice(attrIndex, 1);

                // 判断attributeValue数组是否有数据
                if (specObject.attributeValue.length <= 0) {
                    //如果没有则将规格从entity.goodsDesc.specificationItems中移除
                    var objIndex = $scope.entity.goodsDesc.specificationItems.indexOf(specObject);
                    $scope.entity.goodsDesc.specificationItems.splice(objIndex, 1);

                }


            }


        } else {//没有获取到规格对象，肯定是添加操作
            specObject = {attributeName: '', attributeValue: []};
            specObject.attributeName = specName;
            specObject.attributeValue.push(optionName);
            //定义规格对象，将规格对象添加到 $scope.entity.goodsDesc.specificationItems中保存
            $scope.entity.goodsDesc.specificationItems.push(specObject);
        }

        //alert(JSON.stringify($scope.entity.goodsDesc.specificationItems));

    };


    $scope.createItemList = function () {

        $scope.entity.itemList = [{spec: {}, price: "255", stockCount: "99999", status: "1", isDefault: "1"}];
        for (var i = 0; i < $scope.entity.goodsDesc.specificationItems.length; i++) {
            var spec = $scope.entity.goodsDesc.specificationItems[i];

            //alert(JSON.stringify(spec.attributeValue));
            $scope.entity.itemList = $scope.addCulom($scope.entity.itemList, spec);

        }

    };

    $scope.addCulom = function (itemList, spec) {

        var newList = [];


        //循环itemList，将规格和和库存合并
        for (var i = 0; i < itemList.length; i++) {
            var item = itemList[i];

            //合并结果，遍历规格选项数组
            for (var j = 0; j < spec.attributeValue.length; j++) {
                var newItem = JSON.parse(JSON.stringify(item));
                newItem.spec[spec.attributeName] = spec.attributeValue[j];
                newList.push(newItem);
            }

        }

        //alert(JSON.stringify(newList));
        return newList;

    };

});	
