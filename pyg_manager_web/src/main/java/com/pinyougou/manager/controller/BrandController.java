package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import entity.PageResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference//注入dubbo容器中的service对象
    private TbBrandService tbBrandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        List<TbBrand> all = tbBrandService.findAll();
        return all;
    }

    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbBrand> findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageResult<TbBrand> pageResult = tbBrandService.findPage(page, size);
        return pageResult;
    }
}