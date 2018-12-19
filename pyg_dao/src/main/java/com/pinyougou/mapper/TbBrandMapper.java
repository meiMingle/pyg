package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface TbBrandMapper {
    List<TbBrand> findAll();

    void save(TbBrand tbBrand);

    TbBrand findOne(Long id);

    void update(TbBrand tbBrand);
}
