package com.netease.music.sale.dao;

import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.UserDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 11:13
 **/
@Mapper
@Component
public interface GoodsMapper {
     @Select("select * from Goods")
    public List<Goods> findAllGoodList();

    @Select("select * from Goods Where goodsIsBuy = #{goodsIsBuy}")
    public List<Goods> findAllGoodListByGoodIsBuy(@Param("goodsIsBuy")Integer goodsIsBuy);

    @Select("select * from Goods Where goodsId = #{goodsId} limit 1")
    public Goods findGoodsByGoodsId(@Param("goodsId")Long goodsId);

    @Insert("INSERT INTO Goods (goodsTitle, goodsPicture, goodsPrice, goodsRest, goodsSummary, goodsContext, saleUserID) VALUES (#{goods.goodsTitle}, #{goods.goodsPicture}, #{goods.goodsPrice}, #{goods.goodsRest}, #{goods.goodsSummary}, #{goods.goodsContext}, #{goods.saleUserID})")
    @Options(useGeneratedKeys=true, keyProperty="goods.goodsId")
    public int addGooods(@Param("goods") Goods goods);


    @Update("UPDATE Goods SET goodsTitle=#{goods.goodsTitle}, goodsPicture=#{goods.goodsPicture}, goodsPrice=#{goods.goodsPrice}, goodsRest=#{goods.goodsRest}, goodsSaleNumber=#{goods.goodsSaleNumber}, goodsSummary=#{goods.goodsSummary}, goodsContext=#{goods.goodsContext}, goodsIsBuy=#{goods.goodsIsBuy}, saleUserID=#{goods.saleUserID} WHERE (goodsID=#{goods.goodsId})")
    public int update(@Param("goods") Goods goods);

    @Delete("DELETE FROM goods WHERE goodsID = #{goodsId} AND goodsIsBuy = #{goodsIsBuy}")
    public int delete(@Param("goodsId") Integer goodsId, @Param("goodsIsBuy") Integer goodsIsBuy);

}
