package com.netease.music.sale.service;

import com.netease.music.sale.meta.UserDO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 11:42
 * <div>问：如何惹恼 Web 开发者？</span>
 **/

public interface LoginService {

    /**
     * 处理登陆业务逻辑
     * 如果登陆成功，将用户添加到session中，返回登陆成功信息。
     * 如果登陆失败，返回登陆错误信息
     * @param userName
     * @param userPassword
     * @return
     */
    public UserDO login(String userName, String userPassword);
}
