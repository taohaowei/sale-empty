package com.netease.music.sale.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netease.music.sale.Constant.BaseErrorEnum;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 19:43
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public class Result<T> extends BaseObj {
    private Integer code = 200;
    private String message = "success";
    private T data;


    public Result<T> appendCode(Integer code) {
        this.setCode(code);
        return this;
    }


    public Result<T> appendMessage(String message) {
        this.setMessage(message);
        return this;
    }

    public Result<T> appendData(T data) {
        this.setData(data);
        return this;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String jsonValue() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException var3) {
            return "{\"code\":" + BaseErrorEnum.JSON_PROCESS_ERROR.getCode() + ", \"message\":\"" + var3.getMessage() + "\"}";
        }
    }
}
