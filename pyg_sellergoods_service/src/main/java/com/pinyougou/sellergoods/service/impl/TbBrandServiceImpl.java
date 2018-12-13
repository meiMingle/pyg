package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
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


}
