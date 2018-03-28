package com.netease.music.sale.vo;

import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.ShoppingCar;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/28 9:51
 **/
public class ShoppingCarVo {

    /**
     * 商品标题
     */
    private String  goodsTitle;
    /**
     * 商品图片地址
     */
    private String goodsPicture;

    /**
     * 购物车对象
     */
    private ShoppingCar shoppingCar;

    public ShoppingCarVo(Goods goods, ShoppingCar shoppingCar) {
        this.goodsTitle = goods.getGoodsTitle();
        this.goodsPicture = goods.getGoodsPicture();
        this.shoppingCar = shoppingCar;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }
}
