package com.ezcache.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author : Liuji
 * @program : EzCache
 * @description :
 * @create : 2024-01-14 20:32
 **/
public class AnnotationUtil {

    public static <A extends Annotation> A getAnnotation(JoinPoint joinPoint, Class<A> a) {
        // 获取被代理方法的签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // 获取被代理方法
        Method method = methodSignature.getMethod();

        // 获取注解
        return method.getAnnotation(a);
    }
}
