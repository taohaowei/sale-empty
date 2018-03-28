package com.netease.music.sale.exception;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 10:11
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
