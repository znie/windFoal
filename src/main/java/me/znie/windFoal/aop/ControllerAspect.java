package me.znie.windFoal.aop;

import me.znie.windFoal.annotation.Secret;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

import java.lang.reflect.Method;

/**
 * aspect 切面
 */
@Aspect
@Component
public class ControllerAspect {

    /**
     * 切面
     */
    @Pointcut("@annotation(me.znie.windFoal.annotation.Secret)")
    public void annotationPointCut(){};

    /**
     * 执行前
     * @param joinPoint
     */
    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Secret action = method.getAnnotation(Secret.class);
        System.out.println("方法规则式拦截,"+method.getName());
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Secret action = method.getAnnotation(Secret.class);
        System.out.println("注解式拦截 " + action.path());
        ServletAct
    }



}
