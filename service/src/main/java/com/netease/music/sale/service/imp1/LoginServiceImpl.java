package com.netease.music.sale.service.imp1;

import com.netease.music.sale.manager.UserManager;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 9:33
 * <div>问：如何惹恼 Web 开发者？</span>
 *
 * 处理登陆业务线
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserManager userManager;

    @Override
    public UserDO login(String userName, String userPassword) {
        return userManager.login(userName, userPassword);
    }
}
