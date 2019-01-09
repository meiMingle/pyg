package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.Specification;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference//注入dubbo容器中的service对象
    private SpecificationService specificationService;


    /**
     * @Description -  -    :  查所有
     * @Create -  -  -    ： 2018/12/19 6:13
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  []
     * @Return -  -  -    :  java.util.List<com.pinyougou.pojo.Specification>
     **/
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        List<TbSpecification> all = specificationService.findAll();
        return all;
    }


    /**
     * @Description -  -    :  分页查询
     * @Create -  -  -    ： 2018/12/19 6:16
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  [page, size]
     * @Return -  -  -    :  entity.PageResult<com.pinyougou.pojo.Specification>
     **/
    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbSpecification> findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageResult<TbSpecification> pageResult = specificationService.findPage(page, size);
        return pageResult;
    }


    /**
     * @Description -  -    :  保存
     * @Create -  -  -    ： 2018/12/19 19:56
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  [tbSpecification]
     * @Return -  -  -    :  entity.Result
     **/
    @RequestMapping("/save")
    public Result save(@RequestBody Specification specification) {
        try {
            specificationService.save(specification);
            //保存成功，返回成功信息
            return new Result(true, "保存/修改成功");
        } catch (Exception e) {
            //保存失败，返回错误信息
            e.printStackTrace();
            return new Result(true, "保存/修改失败");
        }
    }


    /**
     * @Description -  -    :  修改前查询
     * @Create -  -  -    ： 2018/12/19 20:20
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  id
     * @Return -  -  -    :  <com.pinyougou.pojo.Specification>
     **/
    @RequestMapping("/findOne/{id}")
    public Specification findOne(@PathVariable("id") Long id) {
        Specification Specification = specificationService.findOne(id);
        return Specification;
    }


    @RequestMapping("/delete/{ids}")
    /*
     * @Description  -  -    :  批量删除
     * @Create    -  -  -    ： 2018/12/20 17:03
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [ids]
     * @Return    -  -  -    :  entity.Result
     **/
    public Result delete(@PathVariable("ids") Long[] ids) {

/*   当页面传来的数据不是以逗号','分格时，可改用此代码解析
        String[] split = str.split(":");
        Long[] ids = new Long[split.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = Long.parseLong(split[i]);
        }
*/

        try {
            specificationService.delete(ids);
            return new Result(true, "delete success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "delete failure");
        }
    }

    @RequestMapping("/findSpecList/{typeTemplateId}")
    public List<Map> findSpecList(@PathVariable("typeTemplateId") Long typeTemplateId) {
        List<Map> specList = specificationService.findSpecList(typeTemplateId);
        return specList;
    }
}