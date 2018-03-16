package com.netease.music.sale.result;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 20:05
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public class ResultTest {

    @Test
    public void jsonValue() {
        Result<Integer> result = new Result<Integer>();
        result.setData(12);
        System.out.println(result.jsonValue());
    }
}