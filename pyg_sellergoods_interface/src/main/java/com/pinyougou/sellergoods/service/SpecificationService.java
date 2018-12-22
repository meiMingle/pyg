package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.Specification;
import entity.PageResult;

import java.util.List;

public interface SpecificationService {
    List<TbSpecification> findAll();

    PageResult<TbSpecification> findPage(Integer page, Integer size);


    void save(Specification specification);

    Specification findOne(Long id);

    void delete(Long[] ids);
}
