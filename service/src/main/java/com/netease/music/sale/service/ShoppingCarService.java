package com.netease.music.sale.service;

import com.netease.music.sale.meta.ShoppingCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:03
 **/
public interface ShoppingCarService {

    /**
     * 先判断商品是否一插入购物车,新增一个购物车
     * @param shoppingCar
     * @return
     */
    int addGoodsInShoppingCar(ShoppingCar shoppingCar);

    /**
     * 批量清空对应ID的物品
     * @param goodsIDList
     * @return
     */
    int deleteGoodsInShoppingCar(List<Long> goodsIDList, Long userId);

    /**
     * 查看某个人的购物车
     * @param buyUserID
     * @return
     */
    List<ShoppingCar> fingAllShoppingByUserID(Long buyUserID);
}
