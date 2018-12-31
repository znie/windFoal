package me.znie.windFoal.jexl;

import org.apache.commons.jexl3.*;

import java.util.Map;

/**
 * jexl解析器
 */
public class JexlParser {

    private static class JexlParserHolder {
        private static final JexlParser INSTANCE = new JexlParser();
    }

    public static JexlParser getInstance(){
        return JexlParserHolder.INSTANCE;
    }

    /**
     * 执行jexl 解析器
     * @param expresion
     * @param jc
     * @return
     */
    private Object parser(String expresion,JexlContext jc){
        //jexl 构建
        JexlEngine jexl = new JexlBuilder().create();
        //表达式
        JexlExpression e = jexl.createExpression(expresion);
        Object o = e.evaluate(jc);
        return o;
    }

    /**
     * 根据map执行表达式
     * @param expresion
     * @param context
     * @return
     */
    public Object parser(String expresion, Map<String,Object> context){
        JexlContext jc = new MapContext(context);
        return this.parser(expresion,jc);
    }


}
