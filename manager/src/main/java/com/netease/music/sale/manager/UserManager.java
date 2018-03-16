package com.netease.music.sale.manager;

import com.netease.music.sale.meta.UserDO;
import org.springframework.stereotype.Component;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 11:35
 * <div>问：如何惹恼 Web 开发者？</span>
 **/

public interface UserManager {

    /**
     * 登陆功能，组装传入的用户登陆信息，查询数据库中是否存在
     * @param userName 传入用户名
     * @param userPassword 传入登陆密码
     * @return 不存在该用户，返回NULL。存在，返回用户信息
     */
    public UserDO login(String userName, String userPassword);
}
