package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TbBrandServiceImpl implements TbBrandService {

    @Resource
    private TbBrandMapper tbBrandMapper;

    public List<TbBrand> findAll() {
        return tbBrandMapper.findAll();
    }

    @Override
    /**
     * @Description  -  -    :  
     * @Create    -  -  -    ： 2018/12/18 20:06 
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [page, size]
     * @Return    -  -  -    :  entity.PageResult<com.pinyougou.pojo.TbBrand>
     **/
    public PageResult<TbBrand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> tbBrandPage = (Page<TbBrand>) tbBrandMapper.findAll();
        PageResult<TbBrand> pageResult = new PageResult<>(tbBrandPage.getTotal(), tbBrandPage.getResult());
        return pageResult;
    }


}
