package com.netease.music.sale.Constant;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 14:16
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public enum  ResultEnum {
    UNKNOWN_ERROR(000,"未知错误"),
    SUCCESS(200,"成功"),
    FAILD(400,"失败"),
    WRONG_PARAM(300,"参数错误"),
    SYS_ERROR(500,"系统错误"),
    LOGIN_FAILD(201,"登陆失败，账号或密码错误"),
    UN_LOGIN(202,"未登录"),
    REST_NOT_ENOUGH(203,"库存不足"),
    DONE_BUY(204,"已购买过同样的商品"),
    DONE_IN_CAR(205,"已添加至购物车，请勿重复添加")

    ;

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
