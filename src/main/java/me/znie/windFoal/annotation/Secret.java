package me.znie.windFoal.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 安全保障定义
 * @author 12815
 *
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Secret {
	
	//当前请求路径
	String path() default "";
	
	boolean isSecret() default false;
	//未登录重定向路径
	String redict() default "";

	//请求参数描述
	Param[] params() default {};
	
	


}
