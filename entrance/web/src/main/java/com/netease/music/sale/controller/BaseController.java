package com.netease.music.sale.controller;

import com.netease.music.sale.Constant.ResultEnum;
import com.netease.music.sale.exception.BaseException;
import com.netease.music.sale.meta.UserDO;
import com.netease.music.sale.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: 陶浩伟
 * @CreateDate: 2018/3/27 10:52
 **/
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({Exception.class})
    public String handleException(HttpServletRequest request, Exception e) {
        logger.error(buildErrorString(request), e);
        return getErrorResultByException(e).jsonValue();
    }

    private String buildErrorString(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exception happened ");
        if(request == null){
            return stringBuilder.toString();
        }
        stringBuilder.append(" in ");
        stringBuilder.append(request.getRequestURL());
        if (!StringUtils.isEmpty(request.getQueryString())) {
            stringBuilder.append("?").append(request.getQueryString());
        }

        return stringBuilder.toString();
    }

    private <T> Result<T> getErrorResultByException(Exception e) {
        if(e instanceof BaseException)
        {
            return new Result().appendCode(((BaseException) e).getCode()).appendMessage(((BaseException) e).getMessage());
        }
        return new Result<T>().appendCode(ResultEnum.SYS_ERROR.getCode()).appendMessage(ResultEnum.SYS_ERROR.getMessage());
    }

    /**
     * @param session
     * @param type 用户不应该是的身份，参考BaseConstants
     * @return
     */
    public UserDO isLogin(HttpSession session, Integer type)
    {
        UserDO userDO = (UserDO) session.getAttribute("user");
        if(userDO == null || userDO.getUserType().equals(type))
        {
            throw new BaseException("用户身份不正确，或者未登录",ResultEnum.UN_LOGIN.getCode());
        }
        return userDO;
    }



    /**
     *  返回成功码
     *
     * @return json格式字符串
     */public String outSuccess()
    {
        return new Result<>().appendCode(ResultEnum.SUCCESS.getCode()).appendMessage(ResultEnum.SUCCESS.getMessage()).jsonValue();
    }

    /**
     *  返回成功码
     *
     * @param data 数据
     * @return json格式字符串
     */
    public String outSuccess(Object data)
    {
        return new Result<>().appendCode(ResultEnum.SUCCESS.getCode()).appendMessage(ResultEnum.SUCCESS.getMessage()).appendData(data).jsonValue();
    }

    /**
     *  失败返回错误码
     *
     * @param resultEnum 数据
     * @return json格式字符串
     */
    public String outFaild(ResultEnum resultEnum)
    {
        return new Result<>().appendCode(resultEnum.getCode()).appendMessage(resultEnum.getMessage()).jsonValue();
    }
}
