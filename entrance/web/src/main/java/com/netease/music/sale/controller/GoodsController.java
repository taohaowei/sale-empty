package com.netease.music.sale.controller;

import com.netease.music.sale.Constant.BaseConstants;
import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.meta.Goods;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 15:59
 **/
@Controller
public class GoodsController extends BaseController{

    @Resource
    private GoodsService goodsService;


    @RequestMapping("/api/musician/sale/publish")
    public String publishGoods(Goods goods, HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.BUYER);
        goods.setSaleUserID(userDO.getUserID());
        if(isErrorParam(goods))
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }
        goodsService.addGooods(goods);
        return outSuccess();
    }


    @RequestMapping("/api/musician/sale/edit/view")
    public String editGoodsView(@RequestParam(value = "goodsId") Long goodsId, HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.BUYER);
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
        return outSuccess(goods);
    }

    @RequestMapping("/api/musician/sale/edit")
    public String editGoods(Goods goods, HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.BUYER);
        if(isErrorParam(goods))
        {
            return outFaild(ResultEnum.WRONG_PARAM);
        }
        Goods goodsByGoodsId = goodsService.findGoodsByGoodsId(goods.getGoodsId());
        bulidUpdateGoods(goods,goodsByGoodsId);
        goodsService.update(goods);
        return outSuccess();
    }

    private void bulidUpdateGoods(Goods goods, Goods goodsByGoodsId) {
        //将数据库的字段和传入的字段做比较，不同的项就是修改的项
        if(StringUtils.isEmpty(goods.getGoodsTitle()))
        {
            goods.setGoodsTitle(goodsByGoodsId.getGoodsTitle());
        }

        if(StringUtils.isEmpty(goods.getGoodsPicture()))
        {
            goods.setGoodsPicture(goodsByGoodsId.getGoodsPicture());
        }

        if(goods.getGoodsPrice() == null)
        {
            goods.setGoodsPrice(goodsByGoodsId.getGoodsPrice());
        }

        if(goods.getGoodsRest() == null)
        {
            goods.setGoodsRest(goodsByGoodsId.getGoodsRest());
        }

        if(goods.getGoodsSaleNumber() == null)
        {
            goods.setGoodsSaleNumber(goodsByGoodsId.getGoodsSaleNumber());
        }

        if(StringUtils.isEmpty(goods.getGoodsSummary()))
        {
            goods.setGoodsSummary(goodsByGoodsId.getGoodsSummary());
        }

        if(StringUtils.isEmpty(goods.getGoodsContext()))
        {
            goods.setGoodsContext(goodsByGoodsId.getGoodsContext());
        }


        if(goods.getGoodsIsBuy() == null)
        {
            goods.setGoodsIsBuy(goodsByGoodsId.getGoodsIsBuy());
        }

        if(goods.getSaleUserID() == null)
        {
            goods.setSaleUserID(goodsByGoodsId.getSaleUserID());
        }

    }




    private boolean isErrorParam(Goods goods) {
        if(goods == null)
        {
            return true;
        }
        if(StringUtils.isEmpty(goods.getGoodsSummary())){
            return true;
        }

        if(StringUtils.isEmpty(goods.getGoodsContext())){
            return true;
        }
        if(StringUtils.isEmpty(goods.getGoodsPrice())){
            return true;
        }
        if(StringUtils.isEmpty(goods.getGoodsRest())){
            return true;
        }
        if(StringUtils.isEmpty(goods.getGoodsPicture())){
            return true;
        }
        if(StringUtils.isEmpty(goods.getGoodsTitle())){
            return true;
        }
        return false;
    }

}
