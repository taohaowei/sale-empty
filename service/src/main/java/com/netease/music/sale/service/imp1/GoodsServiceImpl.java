package com.netease.music.sale.service.imp1;

import com.netease.music.sale.dao.GoodsMapper;
import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.service.GoodsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 11:44
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoodList() {
        return goodsMapper.findAllGoodList();
    }

    @Override
    public List<Goods> findAllGoodListByGoodIsBuy(Integer goodsIsBuy) {
        return goodsMapper.findAllGoodListByGoodIsBuy(goodsIsBuy);
    }

    @Override
    public Goods findGoodsByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsByGoodsId(goodsId);
    }

    @Override
    public int addGooods(Goods goods) {
        return goodsMapper.addGooods(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int delete(Integer goodsId, Integer goodsIsBuy) {
        return goodsMapper.delete(goodsId, goodsIsBuy);
    }
}
