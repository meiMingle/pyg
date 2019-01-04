package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSeller> findAll() {
        return sellerService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage/{page}/{rows}")
    public PageResult findPage(@PathVariable("page") int page, @PathVariable("rows") int rows) {
        return sellerService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param seller
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbSeller seller) {
        try {
            sellerService.add(seller);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param seller
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbSeller seller) {
        try {
            sellerService.update(seller);
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
    public TbSeller findOne(@PathVariable("id") String id) {
        return sellerService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids") String[] ids) {
        try {
            sellerService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param seller
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search/{page}/{rows}")
    public PageResult search(@RequestBody TbSeller seller, @PathVariable("page") int page, @PathVariable("rows") int rows) {
        return sellerService.findPage(seller, page, rows);
    }

    /**
     * 商家审核
     *
     * @param sellerId
     * @param status
     * @return
     */
    @RequestMapping("/auditSeller/{sellerId}/{status}")
    public Result auditSeller(@PathVariable("sellerId") String sellerId, @PathVariable("status") String status) {
        try {
            sellerService.auditSeller(sellerId, status);
            return new Result(true, "审核操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "审核操作失败");
        }


    }

}
