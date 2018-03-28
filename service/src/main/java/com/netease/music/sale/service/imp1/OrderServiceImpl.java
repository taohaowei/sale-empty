package com.netease.music.sale.service.imp1;

import com.netease.music.sale.Constant.BaseConstants;
import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.dao.GoodsMapper;
import com.netease.music.sale.dao.OrderMapper;
import com.netease.music.sale.dao.ShoppingCarMapper;
import com.netease.music.sale.exception.BaseException;
import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.Order;
import com.netease.music.sale.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:36
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private ShoppingCarMapper shoppingCarMapper;



    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addOrder(List<Long> goodsIDs, List<Integer> numbers, Long userId) {
        int count = 0;
        for (int i=0;i<goodsIDs.size();i++)
        {
            Long goodsID = goodsIDs.get(i);
            Goods goods = goodsMapper.findGoodsByGoodsId(goodsID);
            //判断商品是否已购买过
            if(goods.getGoodsIsBuy() == BaseConstants.DONE_BUY)
            {
                throw new BaseException(ResultEnum.DONE_BUY.getMessage(), ResultEnum.DONE_BUY.getCode());
            }
            //判断是否购买的数量大于库存
            if(numbers.get(i) > goods.getGoodsRest())
            {
                throw new BaseException(ResultEnum.REST_NOT_ENOUGH.getMessage(), ResultEnum.REST_NOT_ENOUGH.getCode());
            }else {
                goods.setGoodsRest(goods.getGoodsRest() - numbers.get(i));
                goods.setGoodsSaleNumber(goods.getGoodsSaleNumber()+numbers.get(i));
                goods.setGoodsIsBuy(BaseConstants.DONE_BUY);
            }

            goodsMapper.update(goods);
            shoppingCarMapper.deleteGoodsInShoppingCar(goodsID, userId);
            orderMapper.addOrder(buildOrder(goods,numbers.get(i),userId));
            count++;
        }

        return count;
    }

    @Override
    public List<Order> getAllOrderList(Long buyUserID) {
        return orderMapper.getAllOrderList(buyUserID);
    }

    private Order buildOrder(Goods goods, Integer number, Long userId) {
        Order order = new Order();
        order.setBuyUserID(userId);
        order.setGoodsID(goods.getGoodsId());
        order.setOrderNumber(number);
        order.setOrderPrice(goods.getGoodsPrice());

        return order;
    }
}
