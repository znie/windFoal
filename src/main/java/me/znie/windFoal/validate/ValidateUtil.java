package me.znie.windFoal.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抽象验证类
 * @author znie
 */
public class ValidateUtil {

    /**
     * 单例
     */
    private static class ValidateUtilHolder{
        private static final ValidateUtil INSTANCE = new ValidateUtil();
    }

    public static ValidateUtil getInstance(){
        return ValidateUtilHolder.INSTANCE;
    }

    /**
     * 验证
     * @param regEx 正则表达式
     * @param value 值
     * @return 校验结果
     */
    public boolean validateReg(String regEx,String value){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
