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

    /*
     * @ Description  -  -    :  service层查询所有TbBrand
     * @ Create    -  -  -    ： 2018/12/19 16:12
     * @ Author    -  -  -    ： Ti
     * @ Param     -  -  -    :
     * @ Return    -  -  -    :  java.util.List<com.pinyougou.pojo.TbBrand>
     **/
    public List<TbBrand> findAll() {
        return tbBrandMapper.findAll();
    }

    @Override
    /*
     * @Description  -  -    :  service层分页查询
     * @Create    -  -  -    ： 2018/12/18 20:06
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [page, size]
     * @Return    -  -  -    :  entity.PageResult<com.pinyougou.pojo.TbBrand>
     **/

    public PageResult<TbBrand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> tbBrandPage = (Page<TbBrand>) tbBrandMapper.findAll();
        return new PageResult<>(tbBrandPage.getTotal(), tbBrandPage.getResult());
    }

    @Override
    /**
     * @Description  -  -    :  service保存/修改
     * @Create    -  -  -    ： 2018/12/19 22:13
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [tbBrand]
     * @Return    -  -  -    :  void
     **/
    public void save(TbBrand tbBrand) {
        if (null == tbBrandMapper.findOne(tbBrand.getId())) {
            tbBrandMapper.save(tbBrand);
        } else {
            tbBrandMapper.update(tbBrand);
        }
    }

    @Override
    /*
     * @Description  -  -    :  修改前查询
     * @Create    -  -  -    ： 2018/12/19 22:21
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [id]
     * @Return    -  -  -    :  com.pinyougou.pojo.TbBrand
     **/
    public TbBrand findOne(Long id) {
        return tbBrandMapper.findOne(id);

    }

    /*
     * @Description  -  -    :  批量删除
     * @Create    -  -  -    ： 2018/12/20 16:49
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    : [ids]
     * @Return    -  -  -    : <entity.Result>
     **/
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.delete(id);
        }
    }
}
