package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbFreightTemplate;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface FreightTemplateService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbFreightTemplate> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(TbFreightTemplate freightTemplate);


    /**
     * 修改
     */
    void update(TbFreightTemplate freightTemplate);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    TbFreightTemplate findOne(Long id);


    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(TbFreightTemplate freightTemplate, int pageNum, int pageSize);

}
