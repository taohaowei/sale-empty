package com.netease.music.sale.controller;

import com.netease.music.sale.Constant.BaseConstants;
import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.ShoppingCar;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.service.GoodsService;
import com.netease.music.sale.service.ShoppingCarService;
import com.netease.music.sale.vo.ShoppingCarVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 11:10
 **/
@Controller
public class ShoppingController extends BaseController{

    @Resource
    private GoodsService goodsService;
    @Resource
    private ShoppingCarService shoppingCarService;



    /**
     * 获取首页的列表
     * @param isBuy false时，表示显示所有信息，true时，显示所有未购买的商品
     * @return
     */
    @RequestMapping("/api/musician/sale/show")
    public String show(@RequestParam(value = "is_buy", required = false, defaultValue = "false") boolean isBuy)
    {
        List<Goods> goodsList = new ArrayList<>();
        if(isBuy)
        {
            goodsList = goodsService.findAllGoodListByGoodIsBuy(BaseConstants.UN_BUY);
        }else{
            goodsList = goodsService.findAllGoodList();
        }
        return outSuccess(goodsList);
    }


    /**
     * 获取商品信息
     * @param goodsId 商品信息
     * @return
     */
    @RequestMapping("/api/musician/sale/get")
    public String get(@RequestParam(value = "goods_id") Long goodsId)
    {
        if(goodsId == null)
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
        if(goods == null)
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }
        return outSuccess(goods);
    }


    /**
     * 将商品添加至购物车
     * @param goodsId 商品信息
     * @return
     */
    @RequestMapping("/api/musician/sale/buy")
    public String buy(@RequestParam(value = "goods_id") Long goodsId, HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.SALER);

        if(goodsId == null)
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);

        if(goods == null || goods.getGoodsIsBuy() == BaseConstants.DONE_BUY)
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }

        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setGoodsID(goodsId);
        shoppingCar.setBuyUserID(userDO.getUserID());
        shoppingCarService.addGoodsInShoppingCar(shoppingCar);

        return outSuccess(goods);
    }

    /**
     * 获取登陆买家用户的购物车清单
     * @param session
     * @return
     */
    @RequestMapping("/api/musician/sale/get/carlist")
    public String shoppingCarList(HttpSession session)
    {
        //判断用户是否已经登录，以及判断用户身份
        UserDO userDO = isLogin(session, BaseConstants.SALER);

        List<ShoppingCar> shoppingCars = shoppingCarService.fingAllShoppingByUserID(userDO.getUserID());
        List<ShoppingCarVo> list = buildShoppingCarVo(shoppingCars);

        return outSuccess(list);
    }

    private List<ShoppingCarVo> buildShoppingCarVo(List<ShoppingCar> shoppingCars) {
        List<ShoppingCarVo> shoppingCarVos = new ArrayList<>();
        for (ShoppingCar shoppingCar : shoppingCars) {
            ShoppingCarVo shoppingCarVo = new ShoppingCarVo(goodsService.findGoodsByGoodsId(shoppingCar.getGoodsID()), shoppingCar);
            shoppingCarVos.add(shoppingCarVo);
        }
        return shoppingCarVos;
    }


}
