package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference//注入dubbo容器中的service对象
    private TbBrandService tbBrandService;


    /**
     * @Description -  -    :  查所有
     * @Create -  -  -    ： 2018/12/19 6:13
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  []
     * @Return -  -  -    :  java.util.List<com.pinyougou.pojo.TbBrand>
     **/
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        List<TbBrand> all = tbBrandService.findAll();
        return all;
    }


    /**
     * @Description -  -    :  分页查询
     * @Create -  -  -    ： 2018/12/19 6:16
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  [page, size]
     * @Return -  -  -    :  entity.PageResult<com.pinyougou.pojo.TbBrand>
     **/
    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbBrand> findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageResult<TbBrand> pageResult = tbBrandService.findPage(page, size);
        return pageResult;
    }


    @RequestMapping("/save")
    /**
     * @Description  -  -    :  保存
     * @Create    -  -  -    ： 2018/12/19 19:56 
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [tbBrand]
     * @Return    -  -  -    :  entity.Result
     **/
    public Result save(@RequestBody TbBrand tbBrand) {
        try {
            tbBrandService.save(tbBrand);
            //保存成功，返回成功信息
            return new Result(true, "save success");
        } catch (Exception e) {
            //保存失败，返回错误信息
            e.printStackTrace();
            return new Result(true, "save failure");
        }
    }


    /**
     * @Description -  -    :  修改前查询
     * @Create -  -  -    ： 2018/12/19 20:20
     * @Author -  -  -    ： Ti
     * @Param -  -  -    :  id
     * @Return -  -  -    :  <com.pinyougou.pojo.TbBrand>
     **/
    @RequestMapping("/findOne/{id}")
    public TbBrand findOne(@PathVariable("id") Long id) {
        TbBrand tbBrand = tbBrandService.findOne(id);
        return tbBrand;
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
            tbBrandService.delete(ids);
            return new Result(true, "delete success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "delete failure");
        }
    }
}