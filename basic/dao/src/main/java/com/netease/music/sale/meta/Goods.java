package com.netease.music.sale.meta;

import java.io.Serializable;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 11:14
 **/
public class Goods implements Serializable {


    private Long goodsId;
    /**
     * 商品标题
     */
    private String  goodsTitle;
    /**
     * 商品图片地址
     */
    private String goodsPicture;
    /**
     * 商品价格
     */
    private Double goodsPrice;
    /**
     * 商品库存
     */
    private Integer goodsRest;
    /**
     * 商品已出售数目
     */
    private Integer goodsSaleNumber;
    /**
     * 商品简介
     */
    private String goodsSummary;
    /**
     * 商品内容
     */
    private String goodsContext;
    /**
     * 商品是否被购买过
     */
    private Integer goodsIsBuy;
    /**
     * 出售者用户ID
     */
    private Long saleUserID;

    public Goods() {
    }

    public Goods(String goodsTitle, String goodsPicture, Double goodsPrice, Integer goodsRest, String goodsSummary, String goodsContext) {
        this.goodsTitle = goodsTitle;
        this.goodsPicture = goodsPicture;
        this.goodsPrice = goodsPrice;
        this.goodsRest = goodsRest;
        this.goodsSummary = goodsSummary;
        this.goodsContext = goodsContext;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsRest() {
        return goodsRest;
    }

    public void setGoodsRest(Integer goodsRest) {
        this.goodsRest = goodsRest;
    }

    public Integer getGoodsSaleNumber() {
        return goodsSaleNumber;
    }

    public void setGoodsSaleNumber(Integer goodsSaleNumber) {
        this.goodsSaleNumber = goodsSaleNumber;
    }

    public String getGoodsSummary() {
        return goodsSummary;
    }

    public void setGoodsSummary(String goodsSummary) {
        this.goodsSummary = goodsSummary;
    }

    public String getGoodsContext() {
        return goodsContext;
    }

    public void setGoodsContext(String goodsContext) {
        this.goodsContext = goodsContext;
    }

    public Integer getGoodsIsBuy() {
        return goodsIsBuy;
    }

    public void setGoodsIsBuy(Integer goodsIsBuy) {
        this.goodsIsBuy = goodsIsBuy;
    }

    public Long getSaleUserID() {
        return saleUserID;
    }

    public void setSaleUserID(Long saleUserID) {
        this.saleUserID = saleUserID;
    }
}
