package com.netease.music.sale.dao;

import com.netease.music.sale.meta.ShoppingCar;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 13:59
 **/
@Mapper
@Component
public interface ShoppingCarMapper {

    @Insert("INSERT INTO Shopping_Car(goodsID,buyUserID) values(#{shoppingCar.goodsID},#{shoppingCar.buyUserID})")
    int addGoodsInShoppingCar(@Param("shoppingCar") ShoppingCar shoppingCar);

    @Delete("DELETE FROM Shopping_Car WHERE goodsID = #{goodsID} AND buyUserID = #{buyUserID}")
    int deleteGoodsInShoppingCar(@Param("goodsID") Long goodsID, @Param("buyUserID") Long buyUserID);

    @Select("SELECT * FROM Shopping_Car WHERE buyUserID = #{buyUserID}")
    List<ShoppingCar> fingAllShoppingByUserID(@Param("buyUserID") Long buyUserID);


    @Select("SELECT count(1) FROM Shopping_Car WHERE goodsID = #{goodsID} AND buyUserID = #{buyUserID}")
    int findByGoodsIdAndBuyUserId(@Param("goodsID") Long goodsID, @Param("buyUserID") Long buyUserID);

}
