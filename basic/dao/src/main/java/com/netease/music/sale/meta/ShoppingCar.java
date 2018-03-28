package com.netease.music.sale.meta;

import java.io.Serializable;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 13:57
 * 购物车
 **/
public class ShoppingCar  implements Serializable {


    private Long shoppingCarID;
    private Long goodsID;
    private Long buyUserID;

    public ShoppingCar() {
    }

    public Long getShoppingCarID() {
        return shoppingCarID;
    }

    public void setShoppingCarID(Long shoppingCarID) {
        this.shoppingCarID = shoppingCarID;
    }

    public Long getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }

    public Long getBuyUserID() {
        return buyUserID;
    }

    public void setBuyUserID(Long buyUserID) {
        this.buyUserID = buyUserID;
    }
}
