package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.sellergoods.service.GoodsService;
import com.pinyougou.vo.Goods;
import entity.PageResult;
import entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoods> findAll() {
        return goodsService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage/{page}/{rows}")
    public PageResult findPage(@PathVariable("page") int page, @PathVariable("rows") int rows) {
        TbGoods tbGoods = new TbGoods();
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        tbGoods.setSellerId(sellerId);

        return goodsService.findPage(tbGoods, page, rows);
    }

    /**
     * 增加
     *
     * @param goods
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods) {
        try {

            //将商品和当前商家绑定
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            goods.getTbGoods().setSellerId(name);
            goodsService.add(goods);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbGoods goods) {
        try {
            goodsService.update(goods);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public TbGoods findOne(@PathVariable("id") Long id) {
        return goodsService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids") Long[] ids) {
        try {
            goodsService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search/{page}/{rows}")
    public PageResult search(@RequestBody TbGoods goods, @PathVariable("page") int page, @PathVariable("rows") int rows) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.setSellerId(sellerId);

        return goodsService.findPage(goods, page, rows);
    }

    @RequestMapping("/marketGoods/{selectIds}/{ismarketable}")
    public Result marketGoods(@PathVariable("selectIds") Long[] selectIds, @PathVariable("ismarketable") String ismarketable) {

        String message = "";

        switch (ismarketable) {
            case "1":
                message = "上架";
                break;
            case "0":
                message = "下架";
                break;
        }
        try {
            goodsService.marketGoods(selectIds, ismarketable);
            return new Result(true, message + "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, message + "失败");
        }

    }

}
