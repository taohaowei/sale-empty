package com.netease.music.sale.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 10:32
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@RunWith(SpringRunner.class)
public class MD5UtilTest {

    private String password = "taohaowei";
    private String after_md5_password = "";
//    @Test

    public void md5() {

        after_md5_password = MD5Util.md5(password);
        System.out.println("after_md5_password = "+after_md5_password);
    }

    @Test
    public void authenticatePassword() {
        md5();
        Assert.assertTrue("验证失败",MD5Util.authenticatePassword(after_md5_password,password));
    }
}