package com.netease.music.sale.controller;

import com.netease.music.sale.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/13 15:55
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Controller层运行成功!~"+testService.testService();
    }
}
