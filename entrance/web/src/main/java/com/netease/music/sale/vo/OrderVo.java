package com.netease.music.sale.vo;

import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.Order;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/28 9:51
 **/
public class OrderVo {

    /**
     * 商品标题
     */
    private String  goodsTitle;
    /**
     * 商品图片地址
     */
    private String goodsPicture;
    /**
     * 订单详细
     */
    private Order order;

    public OrderVo(Goods goods, Order order) {
        this.goodsTitle = goods.getGoodsTitle();
        this.goodsPicture = goods.getGoodsPicture();
        this.order = order;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public Order getOrder() {
        return order;
    }


}
