package com.netease.music.sale.manager.imp1;

import com.netease.music.sale.dao.UserMapper;
import com.netease.music.sale.manager.UserManager;
import com.netease.music.sale.meta.UserDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 11:39
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@Component
public class UserManagerImp1 implements UserManager {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO login(String userName, String userPassword) {
        UserDO userDO = new UserDO(userName,userPassword);
        return userMapper.findOne(userDO);
    }
}
