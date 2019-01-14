package com.pinyougou.vo;/*
 * @Description  -  -    :  商品复合类
 * @Create    -  -  -    ： 2019/1/4 15:49
 * @Author    -  -  -    ： Ti
 * @Version   -  -  -    :  1.0
 **/

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    List<TbItem> itemList;
    private TbGoods tbGoods;
    private TbGoodsDesc tbGoodsDesc;

    public Goods() {
    }

    public Goods(List<TbItem> itemList, TbGoods tbGoods, TbGoodsDesc tbGoodsDesc) {
        this.itemList = itemList;
        this.tbGoods = tbGoods;
        this.tbGoodsDesc = tbGoodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }

    public TbGoods getTbGoods() {
        return tbGoods;
    }

    public void setTbGoods(TbGoods tbGoods) {
        this.tbGoods = tbGoods;
    }

    public TbGoodsDesc getTbGoodsDesc() {
        return tbGoodsDesc;
    }

    public void setTbGoodsDesc(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDesc = tbGoodsDesc;
    }
}
