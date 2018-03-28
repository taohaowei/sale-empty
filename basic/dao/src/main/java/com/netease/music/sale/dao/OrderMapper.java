package com.netease.music.sale.dao;

import com.netease.music.sale.meta.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:29
 **/
@Mapper
@Component
public interface OrderMapper {


    @Insert("INSERT INTO sale.order (goodsID, orderPrice, orderNumber, buyUserID) VALUES ( #{order.goodsID}, #{order.orderPrice}, #{order.orderNumber}, #{order.buyUserID})")
    int addOrder(@Param("order") Order order);

    @Select("SELECT * FROM sale.order where buyUserID = #{buyUserID}")
    List<Order> getAllOrderList(@Param("buyUserID") Long buyUserID);

}
