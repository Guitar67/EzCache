package com.ezcache.aop;

import com.ezcache.annotation.EzCache;
import com.ezcache.service.EzCacheService;
import com.ezcache.util.AnnotationUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : Liuji
 * @program : EzCache
 * @description :
 * @create : 2024-01-14 19:38
 **/
@Aspect
@Component
public class EzCacheAspect {

    private final EzCacheService service;

    public EzCacheAspect(EzCacheService service) {
        this.service = service;
    }


    @Pointcut("@annotation(com.ezcache.annotation.EzCache)")
    public void ezCachePointCut() {

    }

    @Around("ezCachePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        EzCache ezCache = AnnotationUtil.getAnnotation(point, EzCache.class);
        Object res = service.get(ezCache);
        if (res == null) {
            res = point.proceed();
            service.put(ezCache, res);
        }
        return res;
    }
}
