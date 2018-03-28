package com.netease.music.sale.controller;

import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 9:41
 * <div>问：如何惹恼 Web 开发者？</span>
 *
 * 用作登陆
 **/
@Controller
@RequestMapping(value = "/view")
public class LoginController extends BaseController{

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String test()
    {
        return "index";
    }


    @ResponseBody
    @RequestMapping("/api/musician/sale/login")
    public String login(@RequestParam("user_name") String userName, @RequestParam("user_password") String userPassword, HttpSession session)
    {
        UserDO userDO = loginService.login(userName, userPassword);
        if(userDO==null){
            return outFaild(ResultEnum.LOGIN_FAILD);
        }

        session.setAttribute("user",userDO);
        return outSuccess();
    }


    @ResponseBody
    @RequestMapping("/api/musician/sale/unlogin")
    public String unlogin(HttpSession session)
    {
        session.setAttribute("user", null);
        return outSuccess();
    }
}




