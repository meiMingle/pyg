package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
import entity.PageResult;
import entity.Result;
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
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        return itemCatService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage/{page}/{rows}")
    public PageResult findPage(@PathVariable("page") int page, @PathVariable("rows") int rows) {
        return itemCatService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.add(itemCat);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.update(itemCat);
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
    public TbItemCat findOne(@PathVariable("id") Long id) {
        return itemCatService.findOne(id);
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
            itemCatService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param itemCat
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search/{page}/{rows}")
    public PageResult search(@RequestBody TbItemCat itemCat, @PathVariable("page") int page, @PathVariable("rows") int rows) {
        return itemCatService.findPage(itemCat, page, rows);
    }


    @RequestMapping("/findItemCatByParentId/{parentId}")
    public List<TbItemCat> findItemCatByParentId(@PathVariable("parentId") Long parentId) {
        List<TbItemCat> itemCatList = itemCatService.findItemCatByParentId(parentId);
        return itemCatList;
    }
}
