package com.netease.music.sale.Constant;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/15 20:01
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
public enum BaseErrorEnum {
    JSON_PROCESS_ERROR(900, "JSON转换异常"),
    EXCEL_PROCESS_ERROR(901, "EXCEL表格生成异常"),
    PARAM_ERROR(902, "参数异常");


    private Integer code;
    private String desc;

    private BaseErrorEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }




    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorCode() {
        return this.name();
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
