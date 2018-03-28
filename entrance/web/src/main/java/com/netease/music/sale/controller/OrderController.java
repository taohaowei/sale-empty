package com.netease.music.sale.controller;

import com.netease.music.sale.Constant.BaseConstants;
import com.netease.music.sale.meta.Order;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.service.GoodsService;
import com.netease.music.sale.service.OrderService;
import com.netease.music.sale.vo.OrderVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 15:57
 **/
@Controller
public class OrderController extends BaseController{


    @Resource
    private OrderService orderService;
    @Resource
    private GoodsService goodsService;

    /**
     * 购买指定用户的商品
     * @param goodsIDs
     * @param session
     * @return
     */
    @RequestMapping("/api/musician/sale/pay")
    public String pay(@RequestParam("goodsId") List<Long> goodsIDs, @RequestParam("number") List<Integer> numbers, HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.SALER);
        orderService.addOrder(goodsIDs,  numbers, userDO.getUserID());
        return outSuccess();
    }


    /**
     * 获取账务清单
     * @return
     */
    @RequestMapping("/api/musician/sale/get/paylist/history")
    public String getPayHistoryList( HttpSession session)
    {
        UserDO userDO = isLogin(session, BaseConstants.SALER);
        List<Order> allOrderList = orderService.getAllOrderList(userDO.getUserID());
        List<OrderVo> list = buildOrderVoList(allOrderList);
        return outSuccess(list);
    }

    private List<OrderVo> buildOrderVoList(List<Order> allOrderList) {
        List<OrderVo> list = new ArrayList<>();
        for (Order order : allOrderList) {
            OrderVo orderVo = new OrderVo(goodsService.findGoodsByGoodsId(order.getGoodsID()), order);
            list.add(orderVo);
        }
        return list;
    }


}
