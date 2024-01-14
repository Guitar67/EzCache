package com.ezcache.aop;

import com.ezcache.annotation.EzLock;
import com.ezcache.service.EzCacheService;
import com.ezcache.util.AnnotationUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : Liuji
 * @program : EzCache
 * @description :
 * @create : 2024-01-14 19:38
 **/
@Aspect
@Component
public class EzLockAspect {

    private final EzCacheService service;

    public EzLockAspect(EzCacheService service) {
        this.service = service;
    }


    @Pointcut("@annotation(com.ezcache.annotation.EzLock)")
    public void ezLockPointCut() {

    }

    @Around("ezLockPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        EzLock ezLock = AnnotationUtil.getAnnotation(point, EzLock.class);
        Object res = point.proceed();
        service.lock(ezLock);
        return res;
    }
}
