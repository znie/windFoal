package me.znie.windFoal.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RUNTIME)
public @interface Param {

	/**参数类型**/
	String type() default "String";
    /** 参数名  */
	String name() default "";
}
