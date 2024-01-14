package com.ezcache.aop;

import com.ezcache.annotation.EzUpdate;
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
public class EzUpdateAspect {

    private final EzCacheService service;

    public EzUpdateAspect(EzCacheService service) {
        this.service = service;
    }


    @Pointcut("@annotation(com.ezcache.annotation.EzUpdate)")
    public void ezUpdatePointCut() {

    }

    @Around("ezUpdatePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        EzUpdate ezUpdate = AnnotationUtil.getAnnotation(point, EzUpdate.class);
        Object res = point.proceed();
        service.update(ezUpdate, res);
        return res;
    }
}
