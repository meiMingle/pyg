package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.Specification;
import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private TbSpecificationMapper tbSpecificationMapper;
    @Resource
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;
    @Resource
    private TbTypeTemplateMapper tbTypeTemplateMapper;


    /*
     * @ Description  -  -    :  service层查询所有Specification
     * @ Create    -  -  -    ： 2018/12/19 16:12
     * @ Author    -  -  -    ： Ti
     * @ Param     -  -  -    :
     * @ Return    -  -  -    :  java.util.List<com.pinyougou.pojo.Specification>
     **/
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }

    @Override
    /*
     * @Description  -  -    :  service层分页查询
     * @Create    -  -  -    ： 2018/12/18 20:06
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [page, size]
     * @Return    -  -  -    :  entity.PageResult<com.pinyougou.pojo.Specification>
     **/

    public PageResult<TbSpecification> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Page<TbSpecification> specificationPage = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);
        return new PageResult<>(specificationPage.getTotal(), specificationPage.getResult());
    }

    @Override
    /**
     * @Description  -  -    :  service保存/修改
     * @Create    -  -  -    ： 2018/12/19 22:13
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [specification]
     * @Return    -  -  -    :  void
     **/
    public void save(Specification specification) {

        //判断是否有主键
        if (null != specification.getSpec().getId()) {

            //1如果有
            //1.1修改规格主表
            tbSpecificationMapper.updateByPrimaryKey(specification.getSpec());
            //1.2删除规格从表
            TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();//创建条件拼接模板
            TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();//创建条件拼接者
            criteria.andSpecIdEqualTo(specification.getSpec().getId());//注入查询条件
            tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);
            //1.3插入规格从表
            for (TbSpecificationOption tbSpecificationOption : specification.getOptionList()) {
                tbSpecificationOption.setSpecId(specification.getSpec().getId());//关联规格主表
                tbSpecificationOptionMapper.insert(tbSpecificationOption);
            }
        } else {

            //2没有主键
            //2.1保存规格主表，返回主键(返回的主键直接封装到了Specification里面的TbSpecification对象里)
            tbSpecificationMapper.insert(specification.getSpec());
            Long id = specification.getSpec().getId();
            //2.2保存规格选项数据,设置主表主键
            for (TbSpecificationOption tbSpecificationOption : specification.getOptionList()) {
                tbSpecificationOption.setSpecId(id);//关联规格主表
                tbSpecificationOptionMapper.insert(tbSpecificationOption);
            }

        }
    }

    @Override
    /*
     * @Description  -  -    :  规格的修改前查询
     * @Create    -  -  -    ： 2018/12/22 19:21
     * @Author    -  -  -    ： Ti
     * @Param     -  -  -    :  [id]
     * @Return    -  -  -    :  com.pinyougou.pojo.Specification
     **/
    public Specification findOne(Long id) {
        //查询规格主表
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        //根据主表id外键查询规格选项从表
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria().andSpecIdEqualTo(id);
        List<TbSpecificationOption> optionList = tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
        //封装到规格对象（中间对象），并返回
        return new Specification(tbSpecification, optionList);
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
            //删除规格主表
            tbSpecificationMapper.deleteByPrimaryKey(id);
            //删除规格从表
            TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();//创建条件拼接模板
            TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();//创建条件拼接者
            criteria.andSpecIdEqualTo(id);//注入查询条件
            tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);
        }
    }

    @Override
    public List<Map> findSpecList(Long typeTemplateId) {

        //从模板表中查询规格列表
        TbTypeTemplate tbTypeTemplate = tbTypeTemplateMapper.selectByPrimaryKey(typeTemplateId);
        List<Map> specList = JSON.parseArray(tbTypeTemplate.getSpecIds(), Map.class);

        //遍历规格列表
        for (Map spec : specList) {


            //获取规格id，从Interger转为Long
            Long specId = ((Integer) spec.get("id")).longValue();

            //根据规格id查询规格选项列表
            TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
            criteria.andSpecIdEqualTo(specId);
            List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);

            //将规格选项列表封装到规格中
            spec.put("optionList", tbSpecificationOptions);
        }
        return specList;
    }
}
