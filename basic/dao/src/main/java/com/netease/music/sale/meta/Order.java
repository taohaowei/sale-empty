package com.netease.music.sale.meta;

import java.util.Date;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:27
 **/
public class Order {

    private Long orderID;
    private Long goodsID;
    private Date orderTime;
    private Double orderPrice;
    private Integer orderNumber;
    private Long buyUserID;


    public Order() {
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getBuyUserID() {
        return buyUserID;
    }

    public void setBuyUserID(Long buyUserID) {
        this.buyUserID = buyUserID;
    }


}
