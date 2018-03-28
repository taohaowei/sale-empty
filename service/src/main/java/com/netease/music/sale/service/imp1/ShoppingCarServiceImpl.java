package com.netease.music.sale.service.imp1;

import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.dao.ShoppingCarMapper;
import com.netease.music.sale.exception.BaseException;
import com.netease.music.sale.meta.ShoppingCar;
import com.netease.music.sale.service.ShoppingCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 14:05
 **/
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {



    @Resource
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public int addGoodsInShoppingCar(ShoppingCar shoppingCar) {
        if(shoppingCarMapper.findByGoodsIdAndBuyUserId(shoppingCar.getGoodsID(), shoppingCar.getBuyUserID())>0)
        {
            throw new BaseException(ResultEnum.DONE_IN_CAR.getMessage(), ResultEnum.DONE_IN_CAR.getCode());
        }
        return shoppingCarMapper.addGoodsInShoppingCar(shoppingCar);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteGoodsInShoppingCar(List<Long> goodsIDList, Long userId) {
        int count = 0;
        Iterator<Long> iterator = goodsIDList.iterator();
        while (iterator.hasNext())
        {
            count += shoppingCarMapper.deleteGoodsInShoppingCar(iterator.next(), userId);
        }
        return count;
    }

    @Override
    public List<ShoppingCar> fingAllShoppingByUserID(Long buyUserID) {
        if(buyUserID == null)
        {
            return new ArrayList<>();
        }
        List<ShoppingCar> list = shoppingCarMapper.fingAllShoppingByUserID(buyUserID);
        if(list == null)
        {
            return new ArrayList<>();
        }
        return list;
    }
}
