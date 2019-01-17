package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;
import com.pinyougou.pojo.TbGoodsExample.Criteria;
import com.pinyougou.sellergoods.service.GoodsService;
import com.pinyougou.vo.Goods;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;
    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;
    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbSellerMapper tbSellerMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;


    /**
     * 查询全部
     */
    @Override
    public List<TbGoods> findAll() {
        return tbGoodsMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);


        //查询所有未审核的商品
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        Criteria criteria = tbGoodsExample.createCriteria();
        criteria.andAuditStatusEqualTo("0");
        Page<TbGoods> page = (Page<TbGoods>) tbGoodsMapper.selectByExample(tbGoodsExample);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Goods goods) {

        //1.保存tbGoods，返回id
        TbGoods tbGoods = goods.getTbGoods();
        tbGoods.setAuditStatus("0");//默认审核状态，未审核
        tbGoodsMapper.insert(tbGoods);
        //2.保存goodsDesc
        TbGoodsDesc tbGoodsDesc = goods.getTbGoodsDesc();
        tbGoodsDesc.setGoodsId(tbGoods.getId());
        tbGoodsDescMapper.insert(tbGoodsDesc);

        //3.保存库存
        //3.1判断是否启用规格
        //3.2是，按照实际库存表保存
        //3.3否，默认保存一条库存数据

        if ("1".equals(tbGoods.getIsEnableSpec())) {
            for (TbItem tbItem : goods.getItemList()) {

                //拼接并设置tbItem的title
                Long brandId = goods.getTbGoods().getBrandId();
                String brandName = tbBrandMapper.selectByPrimaryKey(brandId).getName();
                String goodsName = goods.getTbGoods().getGoodsName();
                String title = brandName;
                Map<String, Object> specMap = JSON.parseObject(tbItem.getSpec());
                for (String key : specMap.keySet()) {
                    title += " " + specMap.get(key);
                }
                title += goodsName;
                tbItem.setTitle(title);
                //将goods里的值映射到tbItem
                setItemValues(goods, tbItem);
                //存入tbItem
                tbItemMapper.insert(tbItem);

            }


        } else {


            TbItem tbItem = new TbItem();
            tbItem.setTitle(goods.getTbGoods().getGoodsName());//商品 SPU+规格描述串作为SKU 名称
            tbItem.setPrice(goods.getTbGoods().getPrice());//价格
            tbItem.setStatus("1");//状态
            tbItem.setIsDefault("1");//是否默认
            tbItem.setNum(99999);//库存数量
            tbItem.setSpec("{}");
            setItemValues(goods, tbItem);
            tbItemMapper.insert(tbItem);

        }
    }


    //
    public TbItem setItemValues(Goods goods, TbItem tbItem) {


        tbItem.setGoodsId(goods.getTbGoods().getId());//商品 SPU 编号
        tbItem.setSellerId(goods.getTbGoods().getSellerId());//商家编号
        tbItem.setCategoryid(goods.getTbGoods().getCategory3Id());//商品分类编号（3 级）
        tbItem.setCreateTime(new Date());//创建日期
        tbItem.setUpdateTime(new Date());//修改日期
        //品牌名称
        TbBrand brand =
                tbBrandMapper.selectByPrimaryKey(goods.getTbGoods().getBrandId());
        tbItem.setBrand(brand.getName());
        //分类名称
        TbItemCat tbItemCat =
                tbItemCatMapper.selectByPrimaryKey(goods.getTbGoods().getCategory3Id());
        tbItem.setCategory(tbItemCat.getName());
        //商家名称
        TbSeller seller =
                tbSellerMapper.selectByPrimaryKey(goods.getTbGoods().getSellerId());
        tbItem.setSeller(seller.getNickName());
        //图片地址（取 spu 的第一个图片）
        List<Map> imageList = JSON.parseArray(goods.getTbGoodsDesc().getItemImages(),
                Map.class);
        if (imageList.size() > 0) {
            tbItem.setImage((String) imageList.get(0).get("url"));
        }


        return tbItem;
    }


    /**
     * 修改
     */
    @Override
    public void update(TbGoods goods) {
        tbGoodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbGoods findOne(Long id) {
        return tbGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbGoodsMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbGoodsExample example = new TbGoodsExample();
        Criteria criteria = example.createCriteria();

        if (goods != null) {
            if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
                criteria.andSellerIdEqualTo(goods.getSellerId());
            }
            if (goods.getGoodsName() != null && goods.getGoodsName().length() > 0) {
                criteria.andGoodsNameLike("%" + goods.getGoodsName() + "%");
            }
            if (goods.getAuditStatus() != null && goods.getAuditStatus().length() > 0) {
                criteria.andAuditStatusEqualTo(goods.getAuditStatus());
            }
            if (goods.getIsMarketable() != null && goods.getIsMarketable().length() > 0) {
                criteria.andIsMarketableLike("%" + goods.getIsMarketable() + "%");
            }
            if (goods.getCaption() != null && goods.getCaption().length() > 0) {
                criteria.andCaptionLike("%" + goods.getCaption() + "%");
            }
            if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
                criteria.andSmallPicLike("%" + goods.getSmallPic() + "%");
            }
            if (goods.getIsEnableSpec() != null && goods.getIsEnableSpec().length() > 0) {
                criteria.andIsEnableSpecLike("%" + goods.getIsEnableSpec() + "%");
            }
            if (goods.getIsDelete() != null && goods.getIsDelete().length() > 0) {
                criteria.andIsDeleteLike("%" + goods.getIsDelete() + "%");
            }

        }

        Page<TbGoods> page = (Page<TbGoods>) tbGoodsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void goodsAudit(Long[] selectIds, String auditStatus) {
        for (Long goodsId : selectIds) {
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsId);
            tbGoods.setAuditStatus(auditStatus);
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
        }
    }

    @Override
    public void deleteGoods(Long[] selectIds) {
        for (Long goodsId : selectIds) {
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsId);
            tbGoods.setIsDelete("1");
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
        }
    }

    @Override
    public void marketGoods(Long[] selectIds, String ismarketable) {
        for (Long selectId : selectIds) {
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(selectId);
            tbGoods.setIsMarketable(ismarketable);
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
        }
    }


}
