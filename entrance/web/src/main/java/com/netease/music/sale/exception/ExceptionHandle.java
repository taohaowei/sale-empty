package com.netease.music.sale.exception;

import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/16 13:50
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String Handle(Exception e)
    {
        if(e instanceof BaseException)
        {
            BaseException loginException = (BaseException)e;
            return new Result().appendCode(loginException.getCode()).appendMessage(loginException.getMessage()).jsonValue();
        }else{
            LOGGER.error("【系统异常】{}",e);
            return new Result().appendCode(ResultEnum.UNKNOWN_ERROR.getCode()).appendMessage(ResultEnum.UNKNOWN_ERROR.getMessage()).jsonValue();
        }

    }
}
