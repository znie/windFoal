package me.znie.windFoal.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证枚举类
 */
public enum ValidateEnum{

    //账号
    ACCOUNT("/^([1-9]{1})(\\d{14}|\\d{18})$/"),
    //邮编
    POSTCODE("^[1-9]\\d{5}$"),
    //邮箱
    EMAIL("^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$ "),
    //手机
    PHONE("^1[3|4|5|8][0-9]\\d{8}$"),
    //身份证 18位
    CERTNO("^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$"),
    //url超链接
    URL("\t^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$ "),
    DATE(),
    TIME(),
    REMARK;

    //正则表达式
    private String regEx;

    private ValidateEnum(){}
    private ValidateEnum(String regEx){
        this.regEx = regEx;
    }

    /**
     * 验证
     * @param value
     * @return
     */
    public boolean validate(String value){

        return ValidateUtil.getInstance().validateReg(this.regEx,value);
    }
}
