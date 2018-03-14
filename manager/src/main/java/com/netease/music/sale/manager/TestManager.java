package com.netease.music.sale.manager;

import com.netease.music.sale.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/14 16:15
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@Component
public class TestManager {

    @Autowired
    private TestDao dao;

    public String testManager()
    {
        return "Manager层连接成功\n\n"+dao.testDao();
    }
}
