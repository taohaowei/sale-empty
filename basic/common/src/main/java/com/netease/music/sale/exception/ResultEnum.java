package com.netease.music.sale.exception;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 14:16
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public enum  ResultEnum {
    UNKNOWN_ERROR(000,"未知错误");


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
