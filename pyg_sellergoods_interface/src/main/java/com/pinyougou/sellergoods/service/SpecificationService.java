package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.Specification;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface SpecificationService {
    List<TbSpecification> findAll();

    PageResult<TbSpecification> findPage(Integer page, Integer size);


    void save(Specification specification);

    Specification findOne(Long id);

    void delete(Long[] ids);

    List<Map> findSpecList(Long typeTemplateId);
}
