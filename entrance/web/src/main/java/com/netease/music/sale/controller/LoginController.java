package com.netease.music.sale.controller;

import com.netease.music.sale.exception.LoginEnum;
import com.netease.music.sale.exception.LoginException;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.result.Result;
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
public class LoginController {

    @Resource
    private LoginService loginService;


//    @GetMapping("/login")
    @ResponseBody
    @RequestMapping(name = "/login")
    public String result(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, HttpSession session)
    {
        UserDO userDO = loginService.login(userName, userPassword);
        if(userDO==null){
            return new Result<UserDO>().appendCode(LoginEnum.LOGIN_FAILD.getCode()).appendMessage(LoginEnum.LOGIN_FAILD.getMessage()).jsonValue();
        }

        session.setAttribute("user",userDO);
        return  new Result<UserDO>().appendCode(LoginEnum.LONGIN_SUCCESS.getCode()).appendMessage(LoginEnum.LONGIN_SUCCESS.getMessage()).jsonValue();
    }
}




