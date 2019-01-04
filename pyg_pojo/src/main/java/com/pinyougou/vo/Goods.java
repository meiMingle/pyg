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
    private TbGoods Goods;
    private TbGoodsDesc GoodsDesc;

    public Goods() {
    }

    public Goods(List<TbItem> itemList, TbGoods goods, TbGoodsDesc goodsDesc) {
        this.itemList = itemList;
        Goods = goods;
        GoodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }

    public TbGoods getGoods() {
        return Goods;
    }

    public void setGoods(TbGoods goods) {
        Goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return GoodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        GoodsDesc = goodsDesc;
    }
}
