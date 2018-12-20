package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface TbBrandService {
    List<TbBrand> findAll();

    PageResult<TbBrand> findPage(Integer page, Integer size);


    void save(TbBrand tbBrand);

    TbBrand findOne(Long id);

    void delete(Long[] ids);
}
