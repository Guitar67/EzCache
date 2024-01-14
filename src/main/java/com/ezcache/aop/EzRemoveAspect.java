package com.ezcache.aop;

import com.ezcache.annotation.EzRemove;
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
public class EzRemoveAspect {

    private final EzCacheService service;

    public EzRemoveAspect(EzCacheService service) {
        this.service = service;
    }


    @Pointcut("@annotation(com.ezcache.annotation.EzRemove)")
    public void ezRemovePointCut() {

    }

    @Around("ezRemovePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        EzRemove ezUpdate = AnnotationUtil.getAnnotation(point, EzRemove.class);
        Object res = point.proceed();
        service.remove(ezUpdate);
        return res;
    }
}
