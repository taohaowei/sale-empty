package com.netease.music.sale.service;

import com.netease.music.sale.manager.TestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/14 15:24
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@Service
public class TestService {

    @Autowired
    private TestManager testManager;

    public String testService()
    {
        return "Service层运行成功!~\n\n"+testManager.testManager();
    }

}
