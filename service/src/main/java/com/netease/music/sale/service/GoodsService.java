package com.netease.music.sale.service;

import com.netease.music.sale.meta.Goods;

import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 11:43
 **/
public interface GoodsService {

    List<Goods> findAllGoodList();

    List<Goods> findAllGoodListByGoodIsBuy(Integer goodsIsBuy);

    Goods findGoodsByGoodsId(Long goodsId);

    int addGooods(Goods goods);


    int update(Goods goods);

    int delete(Integer goodsId,Integer goodsIsBuy);

}
