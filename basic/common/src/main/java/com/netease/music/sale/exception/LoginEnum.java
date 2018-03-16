package com.netease.music.sale.exception;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 9:56
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public enum LoginEnum {
    LOGIN_FAILD(201,"登陆失败，账号或密码错误"),
    LONGIN_SUCCESS(200,"登陆成功");

    private Integer code;
    private String message;

    LoginEnum(Integer code, String message) {
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
