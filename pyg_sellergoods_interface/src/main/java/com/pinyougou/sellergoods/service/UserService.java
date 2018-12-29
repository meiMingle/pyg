package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbUser;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface UserService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbUser> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(TbUser user);


    /**
     * 修改
     */
    void update(TbUser user);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    TbUser findOne(Long id);


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
    PageResult findPage(TbUser user, int pageNum, int pageSize);

}
