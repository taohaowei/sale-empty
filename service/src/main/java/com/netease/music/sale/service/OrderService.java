package com.netease.music.sale.service;

import com.netease.music.sale.meta.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:35
 **/
public interface OrderService {

    /**
     * 向订单数据库中批量插入订单信息
     * @param goodsIDs
     * @param numbers
     * @param userId
     * @return
     */
    int addOrder( List<Long> goodsIDs, List<Integer> numbers, Long userId);


    /**
     * 获取买家的所有账单信息
     * @param buyUserID
     * @return
     */
    List<Order> getAllOrderList(@Param("buyUserID") Long buyUserID);
}
